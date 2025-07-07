package com.acc.model.dto.memo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoDetailsResponseDTO {
    private String severity;
    private String reasonForMemo;
    private String startDate;
    private String endDate;
    private String memoText;
}
