// 인터페이스 - MemberService.java
package com.btw09.buyyourbrain.member.service;

import com.btw09.buyyourbrain.member.vo.Member;

public interface MemberService {

    // 회원가입
    int insertMember(Member m);

}
