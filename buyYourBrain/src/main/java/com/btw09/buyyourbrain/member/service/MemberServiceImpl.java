package com.btw09.buyyourbrain.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.btw09.buyyourbrain.member.dao.MemberDao;
import com.btw09.buyyourbrain.member.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	 @Autowired
	    private MemberDao dao;
	 
	 @Autowired
		private SqlSessionTemplate sqlSession;

	 	//회원가입
	    @Override
	    public int insertMember(Member m) {
	        return dao.insertMember(sqlSession,m);
	    }

	    //로그인 수정필요
//	    @Override
//	    public Member loginMember(String userId) {
//	        return memberDao.selectMemberById(userId);
//	    }

}
