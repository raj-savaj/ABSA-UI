package com.acc.inf.context;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SessionContextDTO {
    private SupervisorContextDTO supervisorContext;
    private String bankCode;
    private String channel;
    private String externalBatchNumber;
    private String externalReferenceNo;
    private String externalSystemAuditTrailNumber;
    private String localDateTimeText;
    private String originalReferenceNo;
    private String overridenWarnings;
    private String postingDateText;
    private String serviceCode;
    private String sessionTicket;
    private String transactionBranch;
    private String userId;
    private String valueDateText;
}
