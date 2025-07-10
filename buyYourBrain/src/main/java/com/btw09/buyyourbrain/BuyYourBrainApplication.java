package com.btw09.buyyourbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BuyYourBrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyYourBrainApplication.class, args);
	}
	@GetMapping("/")
	public String index() {
	    return "redirect:/boot/"; // 혹은 /boot/home 등
	}
}
