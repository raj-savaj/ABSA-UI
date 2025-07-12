package com.acc.model.dto.si;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchInstructionDetailsResponseDTO {
    private String accountNumber;
    private String customerName;
    private Integer branchCode;
    private Integer productCode;
    private String productName;
    private Integer instructionNo; // nullable for ADD mode

    public SearchInstructionDetailsResponseDTO(String accountNumber, String customerName, Integer branchCode, Integer productCode, String productName) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.branchCode = branchCode;
        this.productCode = productCode;
        this.productName = productName;
    }

    public SearchInstructionDetailsResponseDTO(String accountNumber, String customerName, Integer branchCode, Integer productCode, String productName, Integer instructionNo) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.branchCode = branchCode;
        this.productCode = productCode;
        this.productName = productName;
        this.instructionNo = instructionNo;
    }
}
