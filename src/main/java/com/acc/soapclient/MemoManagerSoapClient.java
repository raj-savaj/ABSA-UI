package com.acc.soapclient;

import com.acc.soap.memo.*;

import jakarta.xml.ws.BindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
@Slf4j
public class MemoManagerSoapClient {

    private final MemoManagerSpi soapPort;

    public MemoManagerSoapClient() {
        try {
            URL wsdlURL = new URL("https://fcrapi.uiauat.ke.intra.absaafrica/services/services/MemoManagerSpi?wsdl");
            System.setProperty("javax.net.ssl.trustStore","E:/certs/absastore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "pass2025");
            MemoManagerSpiService service = new MemoManagerSpiService(wsdlURL);
            this.soapPort = service.getMemoManagerSpi();

            ((BindingProvider) soapPort).getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://fcrapi.uiauat.ke.intra.absaafrica/services/services/MemoManagerSpi"
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize SOAP client", e);
        }
    }

    public List<CustomerMemoDTO> fetchMemoDetails(SessionContext sessionContext, long customerId){
        try {
            CustomerMemoResponse customerMemoResponse = this.soapPort.inquireAllCustomerMemo(sessionContext,customerId);
            return customerMemoResponse.getMemoDetails().getItem();
        } catch (FatalException_Exception e) {
            throw new RuntimeException(e);
        }
    }

}
