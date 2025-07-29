package com.acc.controller.transaction;

import com.acc.model.dto.transferfund.TransferFundRequest;
import com.acc.repository.ChAcctMastRepo;
import com.acc.services.TransferFundService;
import com.iflex.fcr.app.deposit.savings.dto.ExtendedDemandDepositResponse;
import com.iflex.fcr.app.deposit.savings.spi.FatalException;
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
public class TransferFundController {

    @Autowired
    private TransferFundService transferFundService;

    @Autowired
    private ChAcctMastRepo accountRepo;

    @PostMapping("transfer_fund")
    public ExtendedDemandDepositResponse fundTransfer(@RequestBody TransferFundRequest request){
        try {
            return transferFundService.transferFund(request);
        } catch (FatalException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("validate-account")
    public ResponseEntity<Map<String, String>> validateToOrFromAccountNumber(@RequestParam String toOrFromAccNum) {
        Long count = accountRepo.countByAcctNo(toOrFromAccNum);
        Map<String, String> response = new HashMap<>();

        if (count == 0) {
            response.put("message", "Account number does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response.put("message", "Account number is valid");
        return ResponseEntity.ok(response);
    }

}
