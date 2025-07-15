package com.acc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ci_custmast")
public class CustomerEntity {

    @Id
    @Column(name = "cod_cust_id")
    private String customerId;

    @Column(name = "nam_cust_full")
    private String customerName;

    @Column(name = "nam_cust_shrt")
    private String customerShortName;

    @Column(name = "cod_cust_natl_id")
    private String customerIC;

    @Column(name = "flg_cust_typ")
    private String type;

    @Column(name = "cod_cc_homebrn")
    private String homeBranch;

    @Column(name = "txt_custadr_add1")
    private String address1;

    @Column(name = "txt_custadr_add2")
    private String address2;

    @Column(name = "txt_custadr_add3")
    private String address3;

    @Column(name = "nam_custadr_city")
    private String city;

    @Column(name = "nam_custadr_state")
    private String state;

    @Column(name = "nam_custadr_cntry")
    private String country;

    @Column(name = "txt_custadr_zip")
    private String zipCode;

    @OneToOne(mappedBy = "customer")
    private ChAcctMast account;

    // Getters and Setters
}
