package com.acc.services;

import com.acc.inf.context.SessionContextDTO;
import com.acc.model.dto.si.*;

import com.acc.repository.DemandDepositInstructionRepository;
import com.acc.soap.FatalException_Exception;
import com.acc.soap.SessionContext;
import com.acc.soap.StandingInstructionInquirySpiReponse;
import com.acc.soap.StandingInstructionMaintenanceResponse;
import com.acc.soapclient.DemandDepositInstructionManagerSoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandDepositInstructionManagerService {

    @Autowired
    DemandDepositInstructionRepository instructionRepository;
    @Autowired
    private DemandDepositInstructionManagerSoapClient demandDepositInstructionManagerSoapClient;

    public StandingInstructionInquirySpiReponse getStandingInstructionDetails(StandingInstructionInquiryRequestDTO request) {
        return demandDepositInstructionManagerSoapClient.inquiryStandingInstruction(convertSessionContentToSoap(request.getSessionContext()), request.getAccountId(), request.getInstructionNumber());
    }


    public StandingInstructionMaintenanceResponse modifyStandingInstruction(StandingInstructionModifyRequestDTO requestDTO) throws FatalException_Exception {
        return demandDepositInstructionManagerSoapClient.modifyStandingInstruction(convertSessionContentToSoap(requestDTO.getSessionContext()), requestDTO.getStandingInstructionDto(), requestDTO.getMaintenanceTicket());
    }


    private StandingInstructionResponseDTO convertInquiryResponse(StandingInstructionInquirySpiReponse instructionInquirySpiReponse ){
        StandingInstructionResponseDTO standingInstructionResponseDTO = new StandingInstructionResponseDTO();
        standingInstructionResponseDTO.setFailureReason(instructionInquirySpiReponse.getStandingInstructionDetails().getPriority());
        return standingInstructionResponseDTO;
    }



    private SessionContext convertSessionContentToSoap(SessionContextDTO sessionContextDTO){
        SessionContext sessionContext = new SessionContext();
        sessionContext.setBankCode(sessionContextDTO.getBankCode());
        sessionContext.setChannel(sessionContextDTO.getChannel());
        sessionContext.setTransactionBranch(sessionContextDTO.getTransactionBranch());
        sessionContext.setUserId(sessionContextDTO.getUserId());
        return sessionContext;
    }

    public StandingInstructionMaintenanceResponse addStandingInstruction(StandingInstructionModifyRequestDTO requestDTO) throws FatalException_Exception {
            return demandDepositInstructionManagerSoapClient.addStandingInstruction(convertSessionContentToSoap(requestDTO.getSessionContext()), requestDTO.getStandingInstructionDto());
    }

    public StandingInstructionMaintenanceResponse deleteStandingInstruction(StandingInstructionDeleteRequestDTO requestDTO) throws FatalException_Exception {
        return demandDepositInstructionManagerSoapClient.deleteStandingInstruction(convertSessionContentToSoap(requestDTO.getSessionContext()), requestDTO.getAccountId(), requestDTO.getInstructionNumber(), requestDTO.getMaintenanceTicket());
    }


    public List<SearchInstructionDetailsResponseDTO> findCustomerInstructionByAccId(SearchInstructionDetailRequestDTO request) {
        if ("ADD".equalsIgnoreCase(request.getMode())) {
            //Object  testing =  instructionRepository.findAddModeData(request.getAccountNumber());;
            List<SearchInstructionDetailsResponseDTO> result = instructionRepository.findAddModeData(request.getAccountNumber());
            System.out.println("Result size: " + result.size());
            result.forEach(r -> System.out.println(r.getAccountNumber()));
            return result;
           // return instructionRepository.findAddModeData(request.getAccountNumber());
        } else {
            return instructionRepository.findInstructionData(request.getAccountNumber());
        }
    }
}
