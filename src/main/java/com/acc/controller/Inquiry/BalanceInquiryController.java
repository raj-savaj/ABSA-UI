package com.acc.controller.Inquiry;

import com.acc.model.dto.balance_inquiry.BalanceInquiryRequestDTO;
import com.acc.model.dto.balance_inquiry.BalanceInquiryResponseDTO;
import com.acc.services.BalanceInquireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class BalanceInquiryController {

    @Autowired
    private BalanceInquireService balanceInquireService;

    @PostMapping("balance_inquiry")
    public BalanceInquiryResponseDTO balanceInquiry(@RequestBody BalanceInquiryRequestDTO balanceInquiryRequest){
        log.info("Received Balance Inquiry Request...");
        return balanceInquireService.balanceInquire(balanceInquiryRequest);
    }

    @GetMapping("balance_inquiry")
    public String balanceInquiryGet(){
        log.info("Received Balance Inquiry Request");
        return "Testing";
    }

}
