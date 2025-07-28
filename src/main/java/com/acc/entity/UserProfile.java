package com.acc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "sm_user_profile")
public class UserProfile {

    @Id
    @Column(name = "cod_user_id")
    private String userId;

    @Column(name = "nam_user")
    private String userName;

    @Column(name = "cod_userno")
    private Integer userNo;

    @Column(name = "cod_cc_brn")
    private Integer branchCode;

    @Column(name = "dat_last_sign_on")
    private Timestamp lastSignOn;

    @Column(name = "txt_email_id")
    private String email;

    @Column(name = "dat_process")
    private Timestamp processDate;

    @Column(name = "dat_last_process")
    private Timestamp lastProcessDate;

}
