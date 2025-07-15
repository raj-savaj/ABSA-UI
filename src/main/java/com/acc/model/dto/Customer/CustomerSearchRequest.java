package com.acc.model.dto.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSearchRequest {

    private String searchCriteria;
    private String searchString;
}
