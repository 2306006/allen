package com.example.t4thymeleaf.service;


import com.example.t4thymeleaf.dto.MemberDTO;
import com.example.t4thymeleaf.model.MemberModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MemberService {
    MemberDTO getMemberById(String memberID);

    public Page<MemberModel> findMemberPage(Pageable pageable);

    public void addMember(MemberDTO memberDTO);

    public void editMember(MemberDTO memberDTO);

    public void deleteMember(MemberDTO memberDTO);
}
