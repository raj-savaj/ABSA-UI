package com.acc.soapclient;


import com.acc.soap.*;
import jakarta.xml.ws.BindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@Slf4j
public class BalanceInquireSoapClient {

    private final DemandDepositMaintenanceSpi soapPort;

    public BalanceInquireSoapClient() {
        try {
            URL wsdlURL = new URL("https://fcrapi.uiauat.ke.intra.absaafrica/services/services/DemandDepositMaintenanceSpi?wsdl");
            System.setProperty("javax.net.ssl.trustStore","E:/certs/absastore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "pass2025");
            DemandDepositMaintenanceSpiService service = new DemandDepositMaintenanceSpiService(wsdlURL);
            this.soapPort = service.getDemandDepositMaintenanceSpi();

            ((BindingProvider) soapPort).getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://fcrapi.uiauat.ke.intra.absaafrica/services/services/DemandDepositMaintenanceSpi"
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize SOAP client", e);
        }
    }

    public AccountMasterInquiryResponse fetchAccountBalance(SessionContext  sessionContext,String accountId){
        try {
            AccountMasterInquiryResponse accountMasterInquiryResponse = soapPort.inquireAccountMasterForMaintenance(sessionContext, accountId, "A");
            log.info("Received SOAP Response...");
            return accountMasterInquiryResponse;
        } catch (FatalException_Exception e) {
            throw new RuntimeException(e);
        }
    }
}
