package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.cart;
import com.example.demo.model.item;

@Controller
public class CartController {

	@Autowired
	HttpSession session;
	@Autowired
	cart cart;
	@Autowired
	Account Account;

	@GetMapping("/")
	public String login() {

		return "account";
	}

	@GetMapping("/logout")
	public String index() {
		session.invalidate();//セッションの破棄
		return "account";
	}

	@PostMapping("/")
	public String login(@RequestParam(name = "name", defaultValue = "") String name,
			Model model) {
		Account.setName(name);
		model.addAttribute("name", name);
		return "cart";
	}

	@GetMapping("/cart/clear")
	public String clear() {
		List<item> allitems = cart.getItems();
		allitems.clear();

		return "cart";
	}

	@GetMapping("/cart")
	public String showCart() {

		return "cart";
	}

	@PostMapping("/cart/add")
	public String showCart２(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "0") int price,

			Model model) {
		//item item = new item(name, price);
		//model.addAttribute("item", item);

		List<item> allitems = cart.getItems();
		allitems.add(new item(name, price));

		return "cart";
	}

}
