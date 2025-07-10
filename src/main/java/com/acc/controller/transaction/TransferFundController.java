package com.acc.controller.transaction;

import com.acc.model.dto.transferfund.TransferFundRequest;
import com.acc.services.TransferFundService;
import com.iflex.fcr.app.deposit.savings.dto.ExtendedDemandDepositResponse;
import com.iflex.fcr.app.deposit.savings.spi.FatalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class TransferFundController {

    @Autowired
    private TransferFundService transferFundService;

    @PostMapping("transfer_fund")
    public ExtendedDemandDepositResponse fundTransfer(@RequestBody TransferFundRequest request){
        try {
            return transferFundService.transferFund(request);
        } catch (FatalException e) {
            throw new RuntimeException(e);
        }

    }


}
