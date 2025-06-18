package com.acc.model.dto.balance_inquiry;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BalanceInquiryResponseDTO {
    private String fullName;
    protected BigDecimal availableBalance;
}
