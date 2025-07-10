package com.acc.services;

import com.acc.inf.context.SessionContextDTO;
import com.acc.model.dto.transferfund.TransferFundRequest;
import com.acc.soapclient.DemandDepositManagerSoapClient;
import com.iflex.fcr.app.context.SessionContext;
import com.iflex.fcr.app.deposit.savings.dto.ExtendedDemandDepositResponse;
import com.iflex.fcr.app.deposit.savings.spi.FatalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransferFundService {

    @Autowired
    DemandDepositManagerSoapClient demandDepositManagerSoapClient;

    public ExtendedDemandDepositResponse transferFund(TransferFundRequest transferFundRequest) throws FatalException {
       return demandDepositManagerSoapClient.transferFundWithDRCRAmount(convertSessionContextToSoap(transferFundRequest.getSessionContext()),
                transferFundRequest.getFromAccountId(),
                transferFundRequest.getAmount(),
                transferFundRequest.getToAccountId(),
                transferFundRequest.getAmount());
    }

    private SessionContext convertSessionContextToSoap(SessionContextDTO sessionContextDTO){
        SessionContext sessionContext = new SessionContext();
        sessionContext.setBankCode(sessionContextDTO.getBankCode());
        sessionContext.setChannel(sessionContextDTO.getChannel());
        sessionContext.setTransactionBranch(sessionContextDTO.getTransactionBranch());
        sessionContext.setUserId(sessionContextDTO.getUserId());
        return sessionContext;
    }

}
