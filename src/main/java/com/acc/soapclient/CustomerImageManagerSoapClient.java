package com.acc.soapclient;

import com.acc.soap.*;
import com.acc.soapclient.interceptor.NamespaceFixInterceptor;
import jakarta.jws.WebParam;
import jakarta.xml.ws.BindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@Slf4j
public class CustomerImageManagerSoapClient {

    private final CustomerImageManagerSpi soapPort;

    public CustomerImageManagerSoapClient() {
        try {
            URL wsdlURL = new URL("https://fcrapi.uiauat.ke.intra.absaafrica/services/services/CustomerImageManagerSpi?wsdl");
            System.setProperty("javax.net.ssl.trustStore","E:/certs/absastore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "pass2025");
            CustomerImageManagerSpiService service = new CustomerImageManagerSpiService(wsdlURL);

            this.soapPort = service.getCustomerImageManagerSpi();

            Client client = org.apache.cxf.frontend.ClientProxy.getClient(this.soapPort);
            client.getInInterceptors().add(new NamespaceFixInterceptor());

            ((BindingProvider) soapPort).getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://fcrapi.uiauat.ke.intra.absaafrica/services/services/CustomerImageManagerSpi"
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize SOAP client", e);
        }
    }

    public CustomerImageInquiryResponse getCustomerImage(SessionContext sessionContext, String imageType,long customerId) throws FatalException_Exception {
        return soapPort.inquireCustomerImage(sessionContext, imageType, customerId);
    }

    public TransactionResponse addCustomerImage(SessionContext sessionContext, CustomerImageDTO customerImageDTO) throws FatalException_Exception {
        return soapPort.addCustomerImage(sessionContext,customerImageDTO);
    }

    public TransactionResponse modifyCustomerImage(SessionContext sessionContext,String imageType,long customerId,String imageData,String versionTicket) throws FatalException_Exception {
        return soapPort.modifyCustomerImage(sessionContext,imageType,customerId,imageData,versionTicket);
    }

}
