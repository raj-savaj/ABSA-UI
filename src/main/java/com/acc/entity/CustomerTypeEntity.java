package com.acc.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ci_cust_types")
public class CustomerTypeEntity {

    @Id
    @Column(name = "flg_cust_typ")
    private String flgCustTyp;

    @Column(name = "txt_cust_typ")
    private String txtCustTyp;

    @Column(name = "flg_typ_class")
    private String flgTypClass;

    @Column(name = "flg_mnt_status")
    private String flgMntStatus;

    // Getters and Setters
}
