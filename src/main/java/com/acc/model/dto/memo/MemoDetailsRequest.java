package com.acc.model.dto.memo;

import com.acc.inf.context.SessionContextDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoDetailsRequest {
    private SessionContextDTO sessionContext;
    private Long customerId;
    private Long customerMemoNumber;
}
