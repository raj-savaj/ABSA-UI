package com.acc.model.dto.memo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerSearchResponseDTO {
    private String customerIc;
    private Long customerId;
    private String customerName;
}
