package com.acc.model.dto.si;

import com.acc.inf.context.SessionContextDTO;
import com.acc.soap.StandingInstructionDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandingInstructionModifyRequestDTO {
    private SessionContextDTO sessionContext;
    private StandingInstructionDTO standingInstructionDto;
    private String maintenanceTicket;
}
