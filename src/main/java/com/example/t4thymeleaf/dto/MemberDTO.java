package com.example.t4thymeleaf.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class MemberDTO {

    private String memberName;

    private String memberNickName;

    private String email;

    private String memberStatus;

    private String memberAccount;

    private String memberPassword;

    private String creator;

    private Timestamp createTime;

    private String modifier;

    private Timestamp updateTime;
}
