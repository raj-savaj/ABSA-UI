package com.acc.soapclient;

import com.acc.soap.*;
import jakarta.xml.ws.BindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@Slf4j
public class DemandDepositInstructionManagerSoapClient {

    private final DemandDepositInstructionManagerSpi soapPort;

    public DemandDepositInstructionManagerSoapClient() {
        try {
            URL wsdlURL = new URL("https://fcrapi.uiauat.ke.intra.absaafrica/services/services/DemandDepositInstructionManagerSpi?wsdl");
            System.setProperty("javax.net.ssl.trustStore","E:/certs/absastore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "pass2025");
            DemandDepositInstructionManagerSpiService service = new DemandDepositInstructionManagerSpiService(wsdlURL);
            this.soapPort = service.getDemandDepositInstructionManagerSpi();

            ((BindingProvider) soapPort).getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://fcrapi.uiauat.ke.intra.absaafrica/services/services/DemandDepositInstructionManagerSpi"
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize SOAP client", e);
        }
    }

    public StandingInstructionInquirySpiReponse inquiryStandingInstruction(SessionContext sessionContext,String accountId,int instructionId){
        try {
            return soapPort.inquireForMaintenance(sessionContext, accountId, instructionId, "z");
        } catch (FatalException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    public StandingInstructionMaintenanceResponse modifyStandingInstruction(SessionContext sessionContext, StandingInstructionDTO standingInstructionDto, String maintenanceTicket) throws FatalException_Exception {
        return soapPort.modifyStandingInstruction(sessionContext, standingInstructionDto, maintenanceTicket);
    }

    public StandingInstructionMaintenanceResponse addStandingInstruction(SessionContext sessionContext, StandingInstructionDTO standingInstructionDto) throws FatalException_Exception {
        return soapPort.addStandingInstruction(sessionContext,standingInstructionDto);
    }

    public StandingInstructionMaintenanceResponse deleteStandingInstruction(SessionContext sessionContext, String accountId, int instructionNumber, String maintenanceTicket) throws FatalException_Exception {
        return soapPort.deleteStandingInstruction(sessionContext,accountId,instructionNumber,maintenanceTicket);
    }

}
