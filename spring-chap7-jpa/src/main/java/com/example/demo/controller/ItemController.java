package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;//inta--------
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping({ "/", "/items" })
	public String index(Model model) {
		//データベースからすべてのカテゴリーリストを取得
		List<Category> categoryList = categoryRepository.findAll();
		//データベースから商品リストを取得
		List<Item> list = itemRepository.findAll();
		//取得したしょうひんりすとをデータ置き場にいつもどうり
		model.addAttribute("categories", categoryList);
		model.addAttribute("items", list);
		//画面遷移
		return "templates/items";
	}

}
