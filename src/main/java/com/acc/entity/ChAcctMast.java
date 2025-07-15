package com.acc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "ch_acct_mast")
@Getter  @Setter
@Immutable
public class ChAcctMast {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "COD_ACCT_NO")
    private String codAcctNo;

    @Column(name = "FLG_MNT_STATUS")
    private String flgMntStatus;

    @Column(name = "COD_CCY")
    private String accountCCY;

    @ManyToOne
    @JoinColumn(name = "cod_cust")
    private CustomerEntity customer;

}
