package com.acc.controller.inquiry;

import com.acc.model.dto.balance_inquiry.BalanceInquiryRequestDTO;
import com.acc.repository.ChAcctMastRepo;
import com.acc.services.BalanceInquireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class BalanceInquiryController {

    @Autowired
    private BalanceInquireService balanceInquireService;

    @Autowired
    private ChAcctMastRepo chAcctMastRepo;

    @PostMapping("balance_inquiry")
    public ResponseEntity<?> balanceInquiry(@RequestBody BalanceInquiryRequestDTO balanceInquiryRequest){
        log.info("Received Balance Inquiry Request...");
        long count = chAcctMastRepo.countByAcctNo(balanceInquiryRequest.getBalanceInquiry().getAccountId());

        if (count == 0) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Account number does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(balanceInquireService.balanceInquire(balanceInquiryRequest));
    }

    @GetMapping("balance_inquiry")
    public String balanceInquiryGet(){
        log.info("Received Balance Inquiry Request");
        return "Testing";
    }

}
