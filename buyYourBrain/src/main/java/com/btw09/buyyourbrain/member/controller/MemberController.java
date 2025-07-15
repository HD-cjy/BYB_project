package com.btw09.buyyourbrain.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btw09.buyyourbrain.member.service.MemberService;
import com.btw09.buyyourbrain.member.vo.Member;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	 private MemberService service;

	 @Autowired
	 private BCryptPasswordEncoder bcrypt;
	 
	 //회원가입으로 이동
	 @GetMapping("/register")
	 public String showRegisterForm(Model model) {
	     // 빈 Member 객체를 미리 넘겨줘야 th:object 사용 가능함
	     model.addAttribute("member", new Member());
	     return "member/memberEnrollForm"; // 타임리프에서는 .html 생략해서 보냄
	 }

	 @PostMapping("/register")
	    public String insertMember(@ModelAttribute Member m,
	                                HttpSession session,
	                                Model model) {
	        // 비밀번호 암호화
	        String encPwd = bcrypt.encode(m.getUserPwd());
	        m.setUserPwd(encPwd);

	        // 회원가입 처리
	        int result = service.insertMember(m);

	        if (result > 0) {
	            session.setAttribute("alertMsg", "회원가입을 환영합니다.");
	            return "redirect:/";
	        } else {
	            model.addAttribute("errorMsg", "회원가입에 실패하였습니다.");
	            return "common/errorPage"; // errorPage.html을 만들 예정이라면
	        }
	    }

}
