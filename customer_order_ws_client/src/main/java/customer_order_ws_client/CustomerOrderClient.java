package customer_order_ws_client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.example.customerorders.CustomerOrdersPortType;
import org.example.customerorders.GetOrderRequest;
import org.example.customerorders.GetOrderResponse;
import org.example.customerorders.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import customer_order_ws.CustomerOrdersImplService;

@SpringBootApplication
public class CustomerOrderClient {

	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(CustomerOrderClient.class, args);
		
			URL webServiceUrl = new URL("http://localhost:8081/services/customerOrdersService?wsdl");
			CustomerOrdersImplService service = new CustomerOrdersImplService(webServiceUrl);
			
			CustomerOrdersPortType customerOrdersImplPort = service.getCustomerOrdersImplPort();
			
			
			GetOrderRequest request = new GetOrderRequest();
			request.setCustomerId(BigInteger.valueOf(1));
			GetOrderResponse response = customerOrdersImplPort.getOrders(request);
			
			List<Order> orders = response.getOrder();
			System.out.println(orders.get(0));
	}

}
