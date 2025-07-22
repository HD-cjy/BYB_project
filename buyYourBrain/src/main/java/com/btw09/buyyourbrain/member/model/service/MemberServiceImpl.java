package com.btw09.buyyourbrain.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btw09.buyyourbrain.member.model.dao.MemberDao;
import com.btw09.buyyourbrain.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final MemberDao dao;
	
	public MemberServiceImpl(MemberDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Member findSelect(int i) {
		// TODO Auto-generated method stub
		return dao.findSelect(sqlSession, i);
	}
	

}
