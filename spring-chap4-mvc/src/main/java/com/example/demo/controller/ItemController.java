package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Item;

@Controller
public class ItemController {

	@GetMapping("/item")
	public String item() {

		return "item";
	}

	@PostMapping("/item")
	public String itempost(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "0") int price, Model model) {

		Item item = new Item(name, price);

		//model.addAttribute("name", name);
		//model.addAttribute("price", price);
		model.addAttribute("item", item);

		return "item";
	}

}
