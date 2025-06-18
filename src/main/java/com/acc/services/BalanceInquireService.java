package com.acc.services;

import com.acc.inf.context.SessionContextDTO;
import com.acc.model.dto.balance_inquiry.BalanceInquiryRequestDTO;
import com.acc.model.dto.balance_inquiry.BalanceInquiryResponseDTO;
import com.acc.soap.AccountBalanceDTO;
import com.acc.soap.AccountMasterInquiryResponse;
import com.acc.soap.SessionContext;
import com.acc.soapclient.BalanceInquireSoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceInquireService {

    @Autowired
    private BalanceInquireSoapClient balanceInquireSoapClient;

    public BalanceInquiryResponseDTO balanceInquire(BalanceInquiryRequestDTO balanceInquiryRequest){
        SessionContext sessionContext = convertSessionContentToSoap(balanceInquiryRequest.getSessionContext());
        String accountNo = balanceInquiryRequest.getBalanceInquiry().getAccountId();
        AccountMasterInquiryResponse accountMasterInquiryResponse = balanceInquireSoapClient.fetchAccountBalance(sessionContext, accountNo);
        return convertToResponseDTO(accountMasterInquiryResponse);
    }

    private SessionContext convertSessionContentToSoap(SessionContextDTO sessionContextDTO){
        SessionContext sessionContext = new SessionContext();
        sessionContext.setBankCode(sessionContextDTO.getBankCode());
        sessionContext.setChannel(sessionContextDTO.getChannel());
        sessionContext.setTransactionBranch(sessionContextDTO.getTransactionBranch());
        sessionContext.setUserId(sessionContextDTO.getUserId());
        return sessionContext;
    }

    private BalanceInquiryResponseDTO convertToResponseDTO(AccountMasterInquiryResponse accountMasterInquiryResponse ){
        BalanceInquiryResponseDTO balanceInquiryResponseDTO = new BalanceInquiryResponseDTO();
        balanceInquiryResponseDTO.setFullName(accountMasterInquiryResponse.getFullName());
        balanceInquiryResponseDTO.setAvailableBalance(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getAvailableBalance());
        return balanceInquiryResponseDTO;
    }


}
