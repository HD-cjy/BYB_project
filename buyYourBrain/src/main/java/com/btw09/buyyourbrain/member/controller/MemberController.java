package com.btw09.buyyourbrain.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.btw09.buyyourbrain.member.service.MemberService;
import com.btw09.buyyourbrain.member.vo.Member;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String registerMember(@RequestBody Member member) {
        int result = service.insertMember(member);
        return result > 0 ? "회원가입 성공" : "회원가입 실패";
    }
}
