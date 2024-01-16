package com.example.t4thymeleaf.service.impl;

import com.example.t4thymeleaf.dao.MemberDAO;
import com.example.t4thymeleaf.dto.MemberDTO;
import com.example.t4thymeleaf.model.MemberModel;
import com.example.t4thymeleaf.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDAO memberDAO;

    @Override
    public MemberDTO getMemberById(String memberID){
        MemberModel memberModel = memberDAO.getById(Long.valueOf(memberID));
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberName(memberModel.getMemberName());
        memberDTO.setMemberNickName(memberModel.getMemberNickName());
        memberDTO.setMemberAccount(memberModel.getMemberAccount());
        memberDTO.setMemberPassword(memberModel.getMemberPassword());
        memberDTO.setMemberStatus(memberModel.getMemberStatus());
        memberDTO.setEmail(memberModel.getEmail());
        memberDTO.setCreateTime(memberModel.getCreateTime());
        memberDTO.setCreator(memberModel.getCreator());
        memberDTO.setModifier(memberModel.getModifier());
        memberDTO.setUpdateTime(memberModel.getUpdateTime());
        return memberDTO;
    }

    @Override
    public void addMember(MemberDTO memberDTO){
        MemberModel memberModel = new MemberModel();
        memberModel.setMemberID(String.valueOf(memberDAO.count()+1));
        memberModel.setMemberName(memberDTO.getMemberName());
        memberModel.setMemberNickName(memberDTO.getMemberNickName());
        memberModel.setMemberAccount(memberDTO.getMemberAccount());
        memberModel.setMemberPassword(memberDTO.getMemberPassword());
        memberModel.setMemberStatus(memberDTO.getMemberStatus());
        memberModel.setEmail(memberDTO.getEmail());
        memberModel.setCreator(memberDTO.getCreator());
        memberModel.setModifier(memberDTO.getModifier());
        memberModel.setMemberStatus("1");
        Date date = new Date();
        Timestamp nowTimeStamp = new Timestamp(date.getTime());
        memberModel.setCreateTime(nowTimeStamp);
        memberModel.setUpdateTime(nowTimeStamp);
        memberDAO.save(memberModel);
    }

    @Override
    public void editMember(MemberDTO memberDTO){

    }

    @Override
    public void deleteMember(MemberDTO memberDTO){

    }
}
