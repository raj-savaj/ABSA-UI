package com.acc.model.dto.transferfund;

import com.acc.inf.context.SessionContextDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferFundRequest {
    private SessionContextDTO sessionContext;
    private String fromAccountId;
    private String toAccountId;
    private double amount;

}
