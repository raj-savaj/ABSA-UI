package com.acc.soapclient;

import com.acc.soap.*;
import jakarta.xml.ws.BindingProvider;
import lombok.extern.slf4j.Slf4j;
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

}
