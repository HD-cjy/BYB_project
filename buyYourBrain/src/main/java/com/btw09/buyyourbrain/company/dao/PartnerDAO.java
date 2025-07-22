package com.btw09.buyyourbrain.company.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.btw09.buyyourbrain.company.model.vo.PartnerCorp;
import com.btw09.buyyourbrain.member.model.vo.Member;

@Repository
public class PartnerDAO {

	public PartnerCorp findSelect(SqlSessionTemplate sqlSession, int i) {
		// TODO Auto-generated method stub
		
		PartnerCorp resultObject = sqlSession.selectOne("partnerMapper.findSelect", i);
		return resultObject;
	}

}
