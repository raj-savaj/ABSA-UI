package com.acc.model.dto.si;

import com.acc.inf.context.SessionContextDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandingInstructionDeleteRequestDTO {
    private SessionContextDTO sessionContext;
    private String accountId;
    private int instructionNumber;
    private String maintenanceTicket;
}
