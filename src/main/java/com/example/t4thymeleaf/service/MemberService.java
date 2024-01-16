package com.example.t4thymeleaf.service;


import com.example.t4thymeleaf.dto.MemberDTO;

public interface MemberService {
    MemberDTO getMemberById(String memberID);

    public void addMember(MemberDTO memberDTO);

    public void editMember(MemberDTO memberDTO);

    public void deleteMember(MemberDTO memberDTO);
}
