package com.acc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "CI_CUSTMEMO")
public class CiCustMemo {

    @Id
    @Column(name = "COD_CUST_ID", nullable = false)
    private Long codCustId;

    @Column(name = "DAT_CUST_MEMO")
    @Temporal(TemporalType.DATE)
    private Date datCustMemo;

    @Column(name = "TXT_CUST_MEMO", length = 762)
    private String txtCustMemo;

    @Column(name = "FLG_SEVERITY", length = 1)
    private String flgSeverity;

    @Column(name = "FLG_MNT_STATUS", length = 1)
    private String flgMntStatus;

    @Column(name = "COD_MNT_ACTION", length = 1)
    private String codMntAction;

    @Column(name = "COD_LAST_MNT_MAKERID", length = 36)
    private String codLastMntMakerId;

    @Column(name = "COD_LAST_MNT_CHKRID", length = 36)
    private String codLastMntChkrId;

    @Column(name = "DAT_LAST_MNT")
    @Temporal(TemporalType.DATE)
    private Date datLastMnt;

    @Column(name = "CTR_UPDAT_SRLNO")
    private Long ctrUpdatSrlNo;

    @Column(name = "COD_REASON")
    private Integer codReason;
}