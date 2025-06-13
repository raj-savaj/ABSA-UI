package com.acc.controller.Inquiry;

import com.acc.model.dto.balance_inquiry.BalanceInquiryRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class BalanceInquiryController {

    @PostMapping("balance_inquiry")
    public String balanceInquiry(@RequestBody BalanceInquiryRequestDTO balanceInquiryRequest){
        log.info("Received Balance Inquiry Request...");
        return "";
    }
}
