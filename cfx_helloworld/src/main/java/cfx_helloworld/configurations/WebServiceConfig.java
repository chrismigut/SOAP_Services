package cfx_helloworld.configurations;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cfx_helloworld.endpoints.HelloWS;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint binding(){
		Endpoint endpoint = new org.apache.cxf.jaxws.EndpointImpl(bus, new HelloWS());
		endpoint.publish("/hello");
		return endpoint;
		
	}
}
