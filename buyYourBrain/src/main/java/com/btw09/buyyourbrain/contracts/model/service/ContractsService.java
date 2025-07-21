package com.btw09.buyyourbrain.contracts.model.service;

import com.btw09.buyyourbrain.member.model.vo.Member;

public interface ContractsService {
	
//	memerID로 객체가져오기 
	Member getObjectById(int workerId);

}
