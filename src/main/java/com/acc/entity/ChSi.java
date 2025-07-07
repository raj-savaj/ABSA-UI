package com.acc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "ci_si_table")
@Getter
@Setter
@Immutable
public class ChSi {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "COD_ACCT_NO")
    private String codAcctNo;

    @Column(name = "FLG_MNT_STATUS")
    private String flgMntStatus;
}
