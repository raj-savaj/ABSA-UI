package com.acc.model.dto.Customer;

import com.acc.inf.context.SessionContextDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerImageRequestDTO {
    private SessionContextDTO sessionContext;
    private Long customerId;
    private String imageType;
}
