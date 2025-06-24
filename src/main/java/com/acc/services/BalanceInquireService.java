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
        balanceInquiryResponseDTO.setAccountCcy(accountMasterInquiryResponse.getAccountCommonInformation().getCurrencyShortName());
        balanceInquiryResponseDTO.setAccountStatus(accountMasterInquiryResponse.getBasicInformationDTO().getAccountStatus());
        balanceInquiryResponseDTO.setCustomerName(accountMasterInquiryResponse.getFullName());
        balanceInquiryResponseDTO.setPrevdayBookBal(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getPreviousEODBookBalance());
        balanceInquiryResponseDTO.setMinBalreqd(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getMinimumBalanceRequired());
        balanceInquiryResponseDTO.setAvalBal(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getAvailableBalance());
        balanceInquiryResponseDTO.setHoldBal(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getBalanceOnHold());
        balanceInquiryResponseDTO.setUnclearedBal(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getUnclearFunds());
        balanceInquiryResponseDTO.setCurrBookBal(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getCurrentBookBalance());
        balanceInquiryResponseDTO.setDrawingPower(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountMasterDetailsDTO().getTotalDrawingPower());
        balanceInquiryResponseDTO.setPassBookBal(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getPassbookBalance());
        balanceInquiryResponseDTO.setNetBalanace(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getNetBalance());
        balanceInquiryResponseDTO.setSweepInAmount(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountMasterDetailsDTO().getSweepInAmountAvailable());
        balanceInquiryResponseDTO.setSweepInAllowed(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getCASAControlAttribute().isIsSweepInAllowed());
        balanceInquiryResponseDTO.setConfAmount(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountBalanceDTO().getConfirmationAmount());
        balanceInquiryResponseDTO.setAdvanceCredit(accountMasterInquiryResponse.getCurrentAndSavingsAccountDTO().getAccountMasterDetailsDTO().getRdAdvanceAmount());
        return balanceInquiryResponseDTO;
    }


}
