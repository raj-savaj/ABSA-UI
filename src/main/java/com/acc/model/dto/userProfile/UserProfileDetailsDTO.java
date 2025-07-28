package com.acc.model.dto.userProfile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class UserProfileDetailsDTO {

    private String userId;
    private String userName;
    private Integer userNo;
    private Integer branchCode;
    private Timestamp lastSignOnDate;
    private String email;
    private Timestamp processDate;
    private Timestamp lastProcessDate;

}
