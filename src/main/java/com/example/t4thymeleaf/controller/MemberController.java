package com.example.t4thymeleaf.controller;

import com.example.t4thymeleaf.dto.MemberDTO;
import com.example.t4thymeleaf.model.MemberModel;
import com.example.t4thymeleaf.service.MemberService;
import com.example.t4thymeleaf.vo.AddMemberVo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String add(AddMemberVo addMemberVo,Model model) {
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
            model.addAttribute("errorMsgBoolean",false);
            model.addAttribute("Msg","新增成功!");
            return "/addMemberView";
        }catch (Exception e){
            log.error("新增錯誤",e);
            model.addAttribute("errorMsgBoolean",true);
            model.addAttribute("errorMsg","新增錯誤");
            return "/addMemberView";
        }
    }

    @RequestMapping(path = "/editMember/{memberAccount}", method = {RequestMethod.GET,RequestMethod.POST})
    public String editMember(@PathVariable("memberAccount") String memberAccount,Model model){

        return "/editMemberView";
    }

    @RequestMapping(path = "/manageMember/{page}", method = {RequestMethod.GET,RequestMethod.POST})
    public String manageMember(@PathVariable("page") int page, Model model){
        int nextPage = page + 1;
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<MemberModel> memberPage = memberService.findMemberPage(pageRequest);
        model.addAttribute("memberPage",memberPage);
        model.addAttribute("nextPage",nextPage);
        return "/manageMemberView";
    }
}
