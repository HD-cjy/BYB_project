package com.btw09.buyyourbrain.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.btw09.buyyourbrain.member.vo.Member;

public class MemberDao {
	
	// 회원가입용 메서드
    public int insertMember(SqlSessionTemplate sqlSession, Member m) {
    	return sqlSession.insert("memberMapper.insertMember",m);
	}

}
