package customer_order_ws;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;
import org.example.customerorders.CreateOrderRequest;
import org.example.customerorders.CreateOrderResponse;
import org.example.customerorders.CustomerOrdersPortType;
import org.example.customerorders.GetOrderRequest;
import org.example.customerorders.GetOrderResponse;
import org.example.customerorders.Order;
import org.example.customerorders.Product;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersImpl implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customerOrders = new HashMap();
	public int currentId = 1;

	public CustomerOrdersImpl() {
		init();
	}

	public void init() {
		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));

		Product product = new Product();
		product.setId(BigInteger.valueOf(1));
		product.setDescription("product description");
		product.setQuantity(BigInteger.valueOf(1));

		order.getProduct().add(product);
		orders.add(order);

		customerOrders.put(BigInteger.valueOf(currentId), orders);
	}

	@Override
	public CreateOrderResponse createOrder(CreateOrderRequest request) {
		BigInteger customerId = request.getCustomerId();
		Order order = new Order();

		List<Order> ordersForCustomer = customerOrders.get(customerId);
		ordersForCustomer.add(currentId++, order);

		CreateOrderResponse response = new CreateOrderResponse();
		response.setResult(true);
		return response;
	}

	@Override
	public GetOrderResponse getOrders(GetOrderRequest request) {

		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);

		GetOrderResponse response = new GetOrderResponse();
		response.getOrder().addAll(orders);
		return response;
	}

}
