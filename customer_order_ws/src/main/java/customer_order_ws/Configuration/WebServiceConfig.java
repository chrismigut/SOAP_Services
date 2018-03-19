package customer_order_ws.Configuration;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import customer_order_ws.CustomerOrdersImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersImpl());
		endpoint.publish("/customerOrdersService");
		return endpoint;
	}
	
}

/*Note to self:
 * Don't put new EndpointImpl(bus, CustomerOrdersImpl.class)
 * This was not a fun bug to fine, this is should be returning
 * an instance of the class.
 */
