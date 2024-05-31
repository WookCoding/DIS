package com.app.dis.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder @ToString
public class DistributorVO {

    private Long distributorId;
    private String distributorName;
    private String distributorEmail;
    private String distributorPassword;
    private String distributorPhoneNumber;
    private String distributor_join_date;
}
