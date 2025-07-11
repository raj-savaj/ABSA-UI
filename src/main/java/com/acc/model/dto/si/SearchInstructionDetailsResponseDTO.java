package com.acc.model.dto.si;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchInstructionDetailsResponseDTO {
    private String accountNumber;
    private String customerName;
    private String branchCode;
    private String productCode;
    private String productName;
    private String instructionNo; // nullable for ADD mode

}
