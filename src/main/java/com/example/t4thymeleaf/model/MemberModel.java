package com.example.t4thymeleaf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "member")
public class MemberModel {

    @Id
    @Column(name = "Member_ID", length = 255, nullable = false ,unique = true)
    private String memberID;

    @Column(name = "Member_Name", length = 255, nullable = false)
    private String memberName;

    @Column(name = "Member_Nick_Name", length = 255, nullable = false)
    private String memberNickName;

    @Column(name = "Email", length = 255, nullable = false ,unique = true)
    private String email;

    @Column(name = "Member_Status", length = 2, nullable = false)
    private String memberStatus;

    @Column(name = "Member_Account", length = 50, nullable = false ,unique = true)
    private String memberAccount;

    @Column(name = "Member_Password", length = 255, nullable = false)
    private String memberPassword;

    @Column(name = "Creator", length = 255, nullable = false)
    private String creator;

    @Column(name = "Create_Time", length = 255, nullable = false)
    private Timestamp createTime;

    @Column(name = "Modifier", length = 255, nullable = false)
    private String modifier;

    @Column(name = "Update_Time", length = 255, nullable = false)
    private Timestamp updateTime;
}
