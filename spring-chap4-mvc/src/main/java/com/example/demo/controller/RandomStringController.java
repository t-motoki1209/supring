package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RandomStringService;

@Controller
public class RandomStringController {

	@Autowired //Di依存性の注入
	RandomStringService service;

	//shokihyouji
	@GetMapping("/random")
	public String index() {

		return "random";
	}

	@PostMapping("/random")
	public String indexpost(
			@RequestParam("charLength") int charLength,
			@RequestParam(name = "WithNumber", defaultValue = "false") boolean WithNumber, Model model) {
		//ランダム文字列の形成
		RandomStringService service = new RandomStringService();
		List<String> list = service.generate(charLength, WithNumber);

		//データ置き場に
		//

		model.addAttribute("randList", list);

		//字画面遷移
		return "random";
	}

}
