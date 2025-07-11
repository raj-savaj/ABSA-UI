package com.acc.controller.mnt;

import com.acc.model.dto.memo.CustomerSearchRequestDTO;
import com.acc.model.dto.memo.CustomerSearchResponseDTO;
import com.acc.model.dto.si.*;
import com.acc.services.DemandDepositInstructionManagerService;
import com.acc.soap.FatalException_Exception;
import com.acc.soap.StandingInstructionInquirySpiReponse;
import com.acc.soap.StandingInstructionMaintenanceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class DemandDepositInstructionManagerController
{
    @Autowired
    private DemandDepositInstructionManagerService demandDepositInstructionManagerService;

    @PostMapping("findCustomerInstructionByAccId")
    public List<SearchInstructionDetailsResponseDTO> findCustomerInstructionByAccId(@RequestBody SearchInstructionDetailRequestDTO requestDTO){
        System.out.println("Calling findCustomerInstructionByAccId with accountNumber: " + requestDTO.getAccountNumber());
        return demandDepositInstructionManagerService.findCustomerInstructionByAccId(requestDTO);
    }

    @PostMapping("getInstructionDetails")
    public StandingInstructionInquirySpiReponse getStandingInstructionDetails(@RequestBody StandingInstructionInquiryRequestDTO request) {
        return demandDepositInstructionManagerService.getStandingInstructionDetails(request);
    }

    @PostMapping("modifyInstructionDetails")
    public StandingInstructionMaintenanceResponse modifyStandingInstruction(@RequestBody StandingInstructionModifyRequestDTO request){
        try {
            return demandDepositInstructionManagerService.modifyStandingInstruction(request);
        } catch (FatalException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("addInstructionDetails")
    public StandingInstructionMaintenanceResponse addStandingInstruction(@RequestBody StandingInstructionModifyRequestDTO request){
        try {
            return demandDepositInstructionManagerService.addStandingInstruction(request);
        } catch (FatalException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("deleteInstructionDetails")
    public StandingInstructionMaintenanceResponse deleteStandingInstruction(@RequestBody StandingInstructionDeleteRequestDTO request){
        try {
            return demandDepositInstructionManagerService.deleteStandingInstruction(request);
        } catch (FatalException_Exception e) {
            throw new RuntimeException(e);
        }
    }

}
