package com.btw09.buyyourbrain.escros.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btw09.buyyourbrain.escros.model.service.EscrosService;
import com.btw09.buyyourbrain.rfid.model.vo.RFIDCard;

@Controller
@RequestMapping("/escros")
public class EscroMasterController {
	
	
	private final EscrosService escroServ;

    public EscroMasterController(EscrosService escroServ) {
        this.escroServ = escroServ;
    }
    
    //0. 에스크로 결제 페이지 조회
    /**
     * @return
     * 사용자와 연결된 "체결됨" 상태의 계약이 있을 경우, 그 계약에 대한 결제 페이지를 화면에 보여줌
     */
    @GetMapping("/paymentReady")
    public String paymentReadyForm() {
    	
    	System.out.println("에스크로 결제 페이지 로직 타는 중");
    	
    	return "escros/escrosPayRequest";
    	
    }
    
    // 0_2. 에스크로 관리자 관리 페이지 조회(일단 화면만 보는 용)
    @GetMapping("/adminPage")
    public String viewAdminPage() {
    	
    	System.out.println("에스크로 관리자 화면 페이지 보는 로직 타는 중");
    	
    	return "escros/escroAdminForm";
    }
    // 1. 에스크로 결제 성공 로직 메소드
    @GetMapping("/paymentSuccess")
    public String paymentSuccessForm() {
    	
    	return "escros/escrosPaySuccess";
    }
   

    // 2. 등록 폼(Create Form)
//    @GetMapping("/create")
//    public String createForm(Model model) {
//        model.addAttribute("rfidCard", new RFIDCard());
//        return "rfid/create";
//    }
//
//    // 3. 등록 처리(Create Action)
//    @PostMapping("/create")
//    public String create(@ModelAttribute RFIDCard rfidCard) {
//        rfidCardService.create(rfidCard);
//        return "redirect:/rfid-cards";
//    }
//
//    // 4. 상세 조회(Read One)
//    @GetMapping("/{id}")
//    public String detail(@PathVariable Long id, Model model) {
//        RFIDCard card = rfidCardService.findById(id);
//        model.addAttribute("rfidCard", card);
//        return "rfid/detail";
//    }
//
//    // 5. 수정 폼(Update Form)
//    @GetMapping("/{id}/edit")
//    public String editForm(@PathVariable Long id, Model model) {
//        RFIDCard card = rfidCardService.findById(id);
//        model.addAttribute("rfidCard", card);
//        return "rfid/edit";
//    }
//
//    // 6. 수정 처리(Update Action)
//    @PostMapping("/{id}/edit")
//    public String edit(@PathVariable Long id, @ModelAttribute RFIDCard rfidCard) {
//        rfidCardService.update(id, rfidCard);
//        return "redirect:/rfid-cards";
//    }
//
//    // 7. 삭제(Delete)
//    @PostMapping("/{id}/delete")
//    public String delete(@PathVariable Long id) {
//        rfidCardService.delete(id);
//        return "redirect:/rfid-cards";
//    }
	

}
