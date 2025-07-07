package com.acc.model.dto.memo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerSearchRequestDTO {
    private String searchCriteria;
    private String searchString;
}
