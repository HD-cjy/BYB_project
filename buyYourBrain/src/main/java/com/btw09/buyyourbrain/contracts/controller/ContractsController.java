package com.btw09.buyyourbrain.contracts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btw09.buyyourbrain.company.model.vo.PartnerCorp;
import com.btw09.buyyourbrain.company.service.PartnerService;
import com.btw09.buyyourbrain.contracts.model.dto.ContracReqtDTO;
import com.btw09.buyyourbrain.contracts.model.service.ContractsService;
import com.btw09.buyyourbrain.contracts.model.vo.Contracts;
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
		
		
//		계약 데이터 새로 생성
		int insertResultC = contractServ.insertContracts(dto);
		
		int contractId = dto.getContractId();
		
		return "redirect:/contracts/createAndSend/success?contractId="+contractId;
	}
	
	@GetMapping("/createAndSend/success")
	public String forwardContractView(int contractId, Model model) {
		
//		계약 객체 불러오기 
		Contracts c = contractServ.getContractById(contractId);
		
//		워커 id
		int workerId = c.getWorkerId();
//		회사 id
		int companyId = c.getCompanyId();
//		계약금액
		int contractPay = c.getContractPrice();
		
		Member worker = contractServ.getObjectById(workerId);
		
		PartnerCorp company = partnServ.findSelect(companyId);
		
//		model에 값 삽입
		model.addAttribute("worker", worker);
		model.addAttribute("company", company);
		model.addAttribute("pay", contractPay);
		
		
		return "contracts/contractForm";
	}
	
	/**
	 * @param dto
	 * @param model
	 * @return
	 * 워커가 클라이언트의 서명을 대기중
	 */
	@PostMapping("/workerPending")
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
		
		return "contracts/workerPending";
	}
	
	/**
	 * @param dto
	 * @param model
	 * @return
	 * 워커의 계약서 폼 
	 */
	@GetMapping("/workerSign")
	public String workerSignForm(ContracReqtDTO dto, Model model) {
		
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
		
		
		
		return "contracts/contractWorkerView";
	}
	
	@PostMapping("/pending")
	public String readyWorkerSign(ContracReqtDTO dto, Model model ) {
		
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
