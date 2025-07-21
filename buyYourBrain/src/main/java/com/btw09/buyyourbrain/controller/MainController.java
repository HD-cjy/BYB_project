package com.btw09.buyyourbrain.controller; // 적절한 패키지로 변경

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index"; // src/main/resources/templates/index.html 파일을 찾아 렌더링
    }

    @GetMapping("/member/enrollForm") // memberEnrollForm.html로 직접 이동하는 경로 추가
    public String memberEnrollForm() {
        return "memberEnrollForm"; // src/main/resources/templates/memberEnrollForm.html을 렌더링
    }
}