package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.AccountModel;

@Controller
public class AccountController {

	@GetMapping("/account")
	public String index(Model model) {
		model.addAttribute("account", new AccountModel());
		return "accountForm";
	}

	@PostMapping("/account")
	public String postindex(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "mail", defaultValue = "") String mail,
			@RequestParam(name = "pass", defaultValue = "") String pass,

			Model model

	) {
		AccountModel account = new AccountModel(name, mail, pass);

		List<String> memoList = new ArrayList<String>();

		int a = 0;

		if (name.equals("")) {
			memoList.add("名前は必須です");
			a = 1;
		}
		if (mail.equals("未設定")) {
			memoList.add("メアドは必須です");
			a = 1;
		}
		if (name.length() > 20) {
			memoList.add("名前は20文字以内です");
			a = 1;
		}
		if (pass.equals("")) {
			memoList.add("パスワードは必須です");
			a = 1;
		}
		if (a == 1) {
			model.addAttribute("memoList", memoList);
			model.addAttribute("account", account);
			return "accountForm";
		} else
			model.addAttribute("account", account);

		return "accountConfirm";

	}
}
