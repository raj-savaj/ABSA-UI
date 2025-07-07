package com.acc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "ci_custmast")
@Getter
@Setter
@Immutable
public class CiCustMast {

    @Id
    @Column(name = "cod_cust_id")
    private Long customerId;

    @Column(name = "nam_cust_full")
    private String fullName;

    @Column(name = "nam_cust_shrt")
    private String shortName;

    @Column(name = "cod_cust_natl_id")
    private String nationalId;

    @Column(name = "flg_mnt_status")
    private String status;
}
