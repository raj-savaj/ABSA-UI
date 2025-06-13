package com.acc.model.dto.balance_inquiry;

import com.acc.inf.context.SessionContextDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BalanceInquiryRequestDTO {
    private SessionContextDTO sessionContext;
    private BalanceInquiryDTO balanceInquiry;
}
