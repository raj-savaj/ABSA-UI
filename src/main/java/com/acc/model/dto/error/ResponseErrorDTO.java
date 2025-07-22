package com.acc.model.dto.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseErrorDTO {

    private String errorCode;
    private String message;
}
