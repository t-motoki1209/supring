package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
	//private static final String username = "student";
	//private static final String userid = "himitu";

	@GetMapping("/index")
	public String index() {

		return "index";
	}

	@PostMapping("/index")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "id", defaultValue = "未設定") String id,

			Model model) {
		List<String> memoList = new ArrayList<String>();

		int a = 0;
		if (name.equals("本木") && id.equals("1")) {
			model.addAttribute("name", name);
			model.addAttribute("id", id);
			return "login";

		}

		if (!name.equals("本木")) {
			memoList.add("名前はまちがえです");
			a = 1;
		}
		if (!id.equals("1")) {
			memoList.add("メアドはまちがえです");
			a = 1;
		}
		if (a == 1) {
			model.addAttribute("memoList", memoList);
			return "index";
		}

		model.addAttribute("name", name);
		model.addAttribute("id", id);
		return "index";
	}

	/*if (name.equals("本木") && id.equals("himitu")) {
		return "login";
	} else {
		String memo = "";
		if (id.equals("himitu")) {
			memo = "a";
		} else {
			memo = "b";
		}
	
		model.addAttribute("memo", memo);
	
	}
	
	return "login";
	}*/

	@GetMapping("/index/login")
	public String login() {

		return "login";
	}

}
