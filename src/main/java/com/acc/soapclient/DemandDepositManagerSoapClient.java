package com.acc.soapclient;

import com.acc.soap.DemandDepositMaintenanceSpiService;
import com.iflex.fcr.app.context.SessionContext;
import com.iflex.fcr.app.deposit.savings.dto.ExtendedDemandDepositResponse;
import com.iflex.fcr.app.deposit.savings.dto.ExtendedReferenceNoDTO;
import com.iflex.fcr.app.deposit.savings.spi.DemandDepositManagerSpi;
import com.iflex.fcr.app.deposit.savings.spi.DemandDepositManagerSpiService;
import com.iflex.fcr.app.deposit.savings.spi.FatalException;
import jakarta.xml.ws.BindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@Slf4j
public class DemandDepositManagerSoapClient {

    private DemandDepositManagerSpi soapPort;

    public DemandDepositManagerSoapClient() {
        try {
            URL wsdlURL = new URL("https://fcrapi.uiauat.ke.intra.absaafrica/services/services/DemandDepositManagerSpi?wsdl");
            System.setProperty("javax.net.ssl.trustStore","E:/certs/absastore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "pass2025");
            DemandDepositManagerSpiService service = new DemandDepositManagerSpiService(wsdlURL);
            this.soapPort = service.getDemandDepositManagerSpi();

            ((BindingProvider) soapPort).getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://fcrapi.uiauat.ke.intra.absaafrica/services/services/DemandDepositManagerSpi"
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize SOAP client", e);
        }
    }

    public ExtendedDemandDepositResponse transferFundWithDRCRAmount(SessionContext sessionContext, String fromAccount,double fromAmount, String toAccount,double toAmount) throws FatalException {

        return soapPort.transferFundsWithDRCRAmount(sessionContext,
                fromAccount,
                fromAmount,
                toAccount,
                toAmount,
                "",
                "",
                false,
                "200",
                true,
                new ExtendedReferenceNoDTO(),
                "N");
    }

}
