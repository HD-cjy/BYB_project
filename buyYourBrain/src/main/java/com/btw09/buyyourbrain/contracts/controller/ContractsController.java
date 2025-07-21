package com.btw09.buyyourbrain.contracts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btw09.buyyourbrain.company.model.vo.PartnerCorp;
import com.btw09.buyyourbrain.company.service.PartnerService;
import com.btw09.buyyourbrain.contracts.model.dto.ContracReqtDTO;
import com.btw09.buyyourbrain.contracts.model.service.ContractsService;
import com.btw09.buyyourbrain.member.model.vo.Member;

@Controller
@RequestMapping("/contracts")
public class ContractsController {
	
	private final ContractsService contractServ;
	private final PartnerService partnServ;
	
	public ContractsController(ContractsService contractServ, PartnerService partnServ) {
		
		this.contractServ = contractServ;
		this.partnServ = partnServ;
	}
	
	/**
	 * @param dto
	 * @param model
	 * @return
	 * 
	 */
	@PostMapping("/createAndSend")
	public String createAutoContract(ContracReqtDTO dto, Model model) {
		
//		dto 객체 내부에 id를 불러옴
//		워커 id
		int workerId = dto.getSelectedWorkerId();
//		회사 id
		int companyId = dto.getCompanyId();
//		계약금액
		int contractpay = dto.getAmountValue();
		
		Member worker = contractServ.getObjectById(workerId);
		
		PartnerCorp company = partnServ.findSelect(companyId);
		
//		model에 값 삽입
		model.addAttribute("worker", worker);
		model.addAttribute("company", company);
		model.addAttribute("pay", contractpay);
		
		
		
		return "contracts/contractForm";
	}
	
	@PostMapping("/pending")
	public String readyClientSign(ContracReqtDTO dto, Model model ) {
		
//		워커 id
		int workerId = dto.getSelectedWorkerId();
//		회사 id
		int companyId = dto.getCompanyId();
//		계약금액
		int contractpay = dto.getAmountValue();
		
		Member worker = contractServ.getObjectById(workerId);
		
		PartnerCorp company = partnServ.findSelect(companyId);
		
//		model에 값 삽입
		model.addAttribute("worker", worker);
		model.addAttribute("company", company);
		model.addAttribute("pay", contractpay);
		
		return "contracts/pending";
	}
	
	/**
	 * @return
	 * 매핑주소는 후에 workerId를 입력해 해당 워커에게 전달하기
	 */
	@PostMapping("/forwardToWorker")
	public String forwardContractToClient() {
		
		System.out.println("워커에게 계약서 주기");
		
		return "contracts/contractWorkerView";
	}
	
	/**
	 * @return
	 * 계약 상태를 변경하는게 아니라 이 시점에서 만들면 될것
	 */
	@PostMapping("/confirm")
	public String contractConfirm() {
		
		System.out.println("두 명 다 동의하던 군요");
		
		return "redirect:/";
		
	}

}
