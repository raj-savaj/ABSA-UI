package com.acc.model.dto.Customer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerDetailResponse {

    private Integer customerId;

    private String occupation;
    private Integer occupationCategory;
    private String designation;
    private Integer tenure;
    private String employerName;

    private String empAddr1;
    private String empAddr2;
    private String empAddr3;
    private String empCity;
    private String empState;
    private String empCountry;
    private String empZip;

    private String empPhone;
    private String empTelex;
    private String empFax;

    private Integer yearsInJob;
    private Integer retirementAge;

    private String creditRating;
    private LocalDate creditRatingDate;

    private String creditCard1Name;
    private String creditCard1Ref;
    private String creditCard2Name;
    private String creditCard2Ref;
    private String creditCard3Name;
    private String creditCard3Ref;

    private String previousEmployer;
    private String previousJobDesignation;
    private String reasonForLeaving;
    private Double lastSalary;

    private String legalCaseFlag;
    private String legalCaseText;
    private String policeRecord;

    private String spouseName;
    private String spouseNationalId;
    private Integer spouseOccupation;
    private String spouseDesignation;
    private LocalDate spouseDob;
    private LocalDate marriageDate;

    private String spouseEmployer;
    private String spouseEmpAddr1;
    private String spouseEmpAddr2;
    private String spouseEmpAddr3;
    private String spouseEmpPhone;

    /*private String maintenanceFlag;
    private String maintenanceAction;
    private String makerId;
    private String checkerId;
    private LocalDate lastModified;
    private Integer updateSerialNo;*/

    // Getters and Setters
}
