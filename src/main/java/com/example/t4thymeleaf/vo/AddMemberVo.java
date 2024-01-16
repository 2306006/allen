package com.example.t4thymeleaf.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberVo {
    private String memberAccount;
    private String memberPassword;
    private String memberName;
    private String memberNickName;
    private String email;
}
