package com.acc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "vwe_ci_custmemo")
@Getter
@Setter
@Immutable
public class CustomerMemo {
    @Id
    @Column(name = "ctr_instr_no")
    private Long memoNumber;

    @Column(name = "cod_cust_id")
    private Long customerId;

    @Column(name = "flg_mnt_status")
    private String status;
}
