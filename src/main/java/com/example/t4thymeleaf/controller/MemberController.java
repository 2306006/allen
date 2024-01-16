package com.example.t4thymeleaf.controller;

import com.example.t4thymeleaf.dto.MemberDTO;
import com.example.t4thymeleaf.service.MemberService;
import com.example.t4thymeleaf.vo.AddMemberVo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(path = "/addMember", method = {RequestMethod.GET,RequestMethod.POST})
    public String addMember( Model model ){
        return "/addMemberView";
    }

    @RequestMapping(path = "/add", method = {RequestMethod.GET,RequestMethod.POST})
    public String add(AddMemberVo addMemberVo) {
        try{
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setMemberAccount(addMemberVo.getMemberAccount());
            memberDTO.setMemberPassword(addMemberVo.getMemberPassword());
            memberDTO.setMemberName(addMemberVo.getMemberName());
            memberDTO.setMemberNickName(addMemberVo.getMemberNickName());
            memberDTO.setEmail(addMemberVo.getEmail());
            memberDTO.setCreator("管理員");
            memberDTO.setModifier("管理員");
            memberService.addMember(memberDTO);
            return "/addMemberView";
        }catch (Exception e){
            log.error("新增錯誤",e);

            return "/addMemberView";
        }
    }

    @RequestMapping(path = "/editMember", method = {RequestMethod.GET,RequestMethod.POST})
    public String editMember(Model model){

        return "/editMemberView";
    }

    @RequestMapping(path = "/manageMember", method = {RequestMethod.GET,RequestMethod.POST})
    public String manageMember(Model model){

        return "/manageMemberView";
    }
}
