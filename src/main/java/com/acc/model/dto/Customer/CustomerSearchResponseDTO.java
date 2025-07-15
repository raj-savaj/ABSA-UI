package com.acc.model.dto.Customer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerSearchResponseDTO {

    private String customerId;
    private String customerName;
    private String customerShortName;
    private String customerIC;
    private String type;
    private String category;
    private String homeBranch;
    private String typeClass;
    private String fullAddress;

    public CustomerSearchResponseDTO(
            String customerId,
            String customerName,
            String customerShortName,
            String customerIC,
            String type,
            String category,
            String homeBranch,
            String typeClass,
            String fullAddress
    ) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerShortName = customerShortName;
        this.customerIC = customerIC;
        this.type = type;
        this.category = category;
        this.homeBranch = homeBranch;
        this.typeClass = typeClass;
        this.fullAddress = fullAddress;
    }
}
