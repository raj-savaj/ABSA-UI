package com.acc.model.dto.balance_inquiry;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BalanceInquiryResponseDTO {
    private String accountCcy;
    private String accountStatus;
    private String customerName;
    private BigDecimal prevdayBookBal;
    private BigDecimal minBalreqd;
    private BigDecimal avalBal;
    private BigDecimal holdBal;
    private BigDecimal unclearedBal;
    private BigDecimal advAgainstUnclrFundsLimit;
    private BigDecimal currBookBal;
    private double drawingPower;
    private double passBookBal;
    private BigDecimal pdcDiscountingLimitAvailble;
    private BigDecimal netBalanace;
    private double sweepInAmount;
    private double advanceCredit;
    private boolean sweepInAllowed;
    private BigDecimal dailyInterEdrAmtUtilized;
    private BigDecimal confAmount;

}
