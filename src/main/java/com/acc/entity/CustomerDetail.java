package com.acc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Entity
@Table(name = "CI_CUSTDETL")
@Getter
@Setter
@Immutable
public class CustomerDetail {

        @Id
        @Column(name = "COD_CUST_ID")
        private Integer customerId;

        @Column(name = "TXT_CUST_OCCUPTN")
        private String occupation;

        @Column(name = "TXT_OCCUPTN_CAT")
        private Integer occupationCategory;

        @Column(name = "TXT_DESIGNATION")
        private String designation;

        @Column(name = "TXT_TENR_OCCUPTN")
        private Integer tenure;

        @Column(name = "NAM_CUST_EMP")
        private String employerName;

        @Column(name = "TXT_EMPADR_ADD1")
        private String empAddr1;

        @Column(name = "TXT_EMPADR_ADD2")
        private String empAddr2;

        @Column(name = "TXT_EMPADR_ADD3")
        private String empAddr3;

        @Column(name = "NAM_EMPADR_CITY")
        private String empCity;

        @Column(name = "NAM_EMPADR_STATE")
        private String empState;

        @Column(name = "NAM_EMPADR_CNTRY")
        private String empCountry;

        @Column(name = "TXT_EMPADR_ZIP")
        private String empZip;

        @Column(name = "REF_CUST_EMP_PHONE")
        private String empPhone;

        @Column(name = "REF_CUST_EMP_TELEX")
        private String empTelex;

        @Column(name = "REF_CUST_EMP_FAX")
        private String empFax;

        @Column(name = "CTR_YRS_JOB")
        private Integer yearsInJob;

        @Column(name = "CTR_AGE_RETIRE")
        private Integer retirementAge;

        @Column(name = "TXT_CR_RATING")
        private String creditRating;

        @Column(name = "DAT_CR_RATING")
        private LocalDate creditRatingDate;

        @Column(name = "NAM_CR_CARD1")
        private String creditCard1Name;

        @Column(name = "REF_CR_CARD1")
        private String creditCard1Ref;

        @Column(name = "NAM_CR_CARD2")
        private String creditCard2Name;

        @Column(name = "REF_CR_CARD2")
        private String creditCard2Ref;

        @Column(name = "NAM_CR_CARD3")
        private String creditCard3Name;

        @Column(name = "REF_CR_CARD3")
        private String creditCard3Ref;

        @Column(name = "NAM_PREV_EMP")
        private String previousEmployer;

        @Column(name = "TXT_DESGN_PREVJOB")
        private String previousJobDesignation;

        @Column(name = "TXT_RSN_LEFT_JOB")
        private String reasonForLeaving;

        @Column(name = "AMT_LAST_SAL")
        private Double lastSalary;

        @Column(name = "FLG_LGL_CASE")
        private String legalCaseFlag;

        @Column(name = "TXT_LGL_CASE")
        private String legalCaseText;

        @Column(name = "TXT_POLICE_RECRD")
        private String policeRecord;

        @Column(name = "NAM_SPOUSE_CUST")
        private String spouseName;

        @Column(name = "COD_NATL_ID_SPOUSE")
        private String spouseNationalId;

        @Column(name = "TXT_OCCPN_SPOUSE")
        private Integer spouseOccupation;

        @Column(name = "TXT_SPO_DESGN")
        private String spouseDesignation;

        @Column(name = "DAT_DOB_SPOUSE")
        private LocalDate spouseDob;

        @Column(name = "DAT_MARRIAGE")
        private LocalDate marriageDate;

        @Column(name = "NAM_SPO_EMPLOYER")
        private String spouseEmployer;

        @Column(name = "TXT_ADDR1_SPO_EMP")
        private String spouseEmpAddr1;

        @Column(name = "TXT_ADDR2_SPO_EMP")
        private String spouseEmpAddr2;

        @Column(name = "TXT_ADDR3_SPO_EMP")
        private String spouseEmpAddr3;

        @Column(name = "REF_SPO_EMP_PHONE")
        private String spouseEmpPhone;

        @Column(name = "FLG_MNT_STATUS")
        private String maintenanceFlag;

        @Column(name = "COD_MNT_ACTION")
        private String maintenanceAction;

        @Column(name = "COD_LAST_MNT_MAKERID")
        private String makerId;

        @Column(name = "COD_LAST_MNT_CHKRID")
        private String checkerId;

        @Column(name = "DAT_LAST_MNT")
        private LocalDate lastModified;

        @Column(name = "CTR_UPDAT_SRLNO")
        private Integer updateSerialNo;

        // Getters and Setters (can be generated with Lombok or manually)
}
