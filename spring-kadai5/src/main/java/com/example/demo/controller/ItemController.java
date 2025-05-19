package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.entity.Category;
import com.example.demo.entity.Item;

@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/")
	public String index(Model model) {

		List<Category> categoryList = categoryRepository.findAll();

		List<Item> list = itemRepository.findAll();

		model.addAttribute("categories", categoryList);
		model.addAttribute("items", list);

		return "items";
	}

	@GetMapping("/items")
	public String items(@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "maxprice", defaultValue = "0") Integer maxprice,

			Model model) {

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);
		List<Item> list = null;
		if (categoryId == null) {
			itemRepository.findAll();
		} else {
			list = itemRepository.findByCategoryId(categoryId);
		}
		List<Item> list1 = null;
		if (maxprice == 0) {
			itemRepository.findAll();
		} else {
			list1 = itemRepository.findBypriceLessThanEqual(maxprice);
		}

		model.addAttribute("items", list);
		model.addAttribute("items", list1);

		return "items";
	}
}

/*@GetMapping("/items/ppp")
public String itemse(@RequestParam(name = "maxprice", defaultValue = "0") Integer maxprice,

		Model model

) {
	
	List<Item> list = null;
	
	if(maxprice !=null) {
	
	list = itemRepository.findBypriceLessThan(maxprice);}
	else {if(category==0) {
		itemRepository.findAll();}
	else {list = itemRepository.findByCategoryId(categoryId);}
	return "/items";

}*/
