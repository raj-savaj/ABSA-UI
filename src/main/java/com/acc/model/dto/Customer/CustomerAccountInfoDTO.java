package com.acc.model.dto.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAccountInfoDTO {

    private String accountNo;
    private Integer accountCCY;
    private Integer customerId;
    private String customerName;
    private String customerShortName;
    private String customerIC;
    private Character type;
    private String category;
    private Integer homeBranch;
    private String status;
    private Character classType;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public CustomerAccountInfoDTO(String accountNo, Integer accountCCY, Integer customerId, String customerName, String customerShortName, String customerIC, Character type, String category, Integer homeBranch, String status, Character classType, String address1, String address2, String address3, String city, String state, String country, String zipCode) {
        this.accountNo = accountNo;
        this.accountCCY = accountCCY;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerShortName = customerShortName;
        this.customerIC = customerIC;
        this.type = type;
        this.category = category;
        this.homeBranch = homeBranch;
        this.status = status;
        this.classType = classType;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
