package com.btw09.buyyourbrain.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository; // Add this import

import com.btw09.buyyourbrain.member.vo.Member;

@Repository // Add this annotation to make it a Spring bean
public class MemberDao {

    // 회원가입용 메서드
    public int insertMember(SqlSessionTemplate sqlSession, Member m) {
        return sqlSession.insert("memberMapper.insertMember",m);
    }

}