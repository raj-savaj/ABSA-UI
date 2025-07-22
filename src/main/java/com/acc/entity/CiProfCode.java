package com.acc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "ci_prof_codes")
public class CiProfCode {

    @Id
    @Column(name = "txt_profess_cat")
    private String txtProfessCat;

    @Column(name = "txt_profession")
    private String txtProfession;

    @Column(name = "flg_mnt_status")
    private String flgMntStatus;

    @Column(name = "cod_last_mnt_makerid")
    private String codLastMntMakerid;

    @Column(name = "cod_last_mnt_chkrid")
    private String codLastMntChkrid;

    @Column(name = "dat_last_mnt")
    private LocalDate datLastMnt;

    @Column(name = "ctr_updat_srlno")
    private int ctrUpdatSrlno;
}
