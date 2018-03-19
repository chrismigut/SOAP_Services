package customer_order_ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import org.example.customerorders.CustomerOrdersPortType;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-03-18T22:12:54.593-07:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "CustomerOrdersImplService", 
                  wsdlLocation = "file:/C:/Users/cmigu/eclipse-workspace/customer_order_ws_client/src/main/resources/CustomerOrdersService.wsdl",
                  targetNamespace = "http://customer_order_ws/") 
public class CustomerOrdersImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://customer_order_ws/", "CustomerOrdersImplService");
    public final static QName CustomerOrdersImplPort = new QName("http://customer_order_ws/", "CustomerOrdersImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/cmigu/eclipse-workspace/customer_order_ws_client/src/main/resources/CustomerOrdersService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerOrdersImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/cmigu/eclipse-workspace/customer_order_ws_client/src/main/resources/CustomerOrdersService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerOrdersImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerOrdersImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerOrdersImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CustomerOrdersImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerOrdersImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CustomerOrdersImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersImplPort")
    public CustomerOrdersPortType getCustomerOrdersImplPort() {
        return super.getPort(CustomerOrdersImplPort, CustomerOrdersPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersImplPort")
    public CustomerOrdersPortType getCustomerOrdersImplPort(WebServiceFeature... features) {
        return super.getPort(CustomerOrdersImplPort, CustomerOrdersPortType.class, features);
    }

}
