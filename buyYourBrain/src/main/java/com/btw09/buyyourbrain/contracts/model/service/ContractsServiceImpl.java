package com.btw09.buyyourbrain.contracts.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btw09.buyyourbrain.contracts.model.dao.ContractsDAO;
import com.btw09.buyyourbrain.member.model.vo.Member;

@Service
public class ContractsServiceImpl implements ContractsService {

	private final ContractsDAO dao;
	
	public ContractsServiceImpl( ContractsDAO dao ) {
		this.dao = dao;
	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member getObjectById(int workerId) {
		// TODO Auto-generated method stub
		return dao.getObjectById(sqlSession, workerId);
	}

}
