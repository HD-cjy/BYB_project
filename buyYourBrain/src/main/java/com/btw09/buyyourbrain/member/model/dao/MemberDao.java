package com.btw09.buyyourbrain.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.btw09.buyyourbrain.member.model.vo.Member;

@Repository
public class MemberDao {

	public Member findSelect(SqlSessionTemplate sqlSession, int i) {
		// TODO Auto-generated method stub
		Member resultMem = sqlSession.selectOne("memberMapper.findSelect", i);
		
		return  resultMem;
	}
	
	

}
