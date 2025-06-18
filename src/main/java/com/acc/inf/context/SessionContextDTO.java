package com.acc.inf.context;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SessionContextDTO {
    private SupervisorContextDTO supervisorContext;
    protected int bankCode;
    protected String channel;
    protected long externalBatchNumber;
    protected String externalReferenceNo;
    protected long externalSystemAuditTrailNumber;
    protected String localDateTimeText;
    protected String originalReferenceNo;
    protected String overridenWarnings;
    protected String postingDateText;
    protected String serviceCode;
    protected String sessionTicket;
    protected int transactionBranch;
    protected String userId;
    protected String userReferenceNumber;
    protected String valueDateText;
}
