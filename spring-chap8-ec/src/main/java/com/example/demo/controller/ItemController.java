package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	// 商品一覧表示
	@GetMapping("/items/{id}")
	public String show(
			@PathVariable(name = "id") Integer id,
			Model model) {
		Item item = itemRepository.findById(id).get();

		model.addAttribute("id", id);
		model.addAttribute("item", item);

		return "itemDetail";
	}

	/*@GetMapping("/items/{id}")
	public String show(@PathVariable Integer id, Model model) {
		Item item = itemRepository.findById(id).orElse(null);
		if (item == null) {
			return "redirect/items";
		}
		model.addAttribute("item", item);
	
		return "itemDetail";
	}*/

	@GetMapping("/items")

	public String index(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			@RequestParam(name = "maxPrice", defaultValue = "") Integer maxPrice,
			@RequestParam(name = "sort", defaultValue = "") String sort,

			Model model) {

		// 全カテゴリー一覧を取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		// 商品一覧情報の取得
		/*List<Item> itemList = null;
		if (categoryId != null) {
			itemList = itemRepository.findByCategoryId(categoryId);
		} else if ("priceAsc".equals(sort)) {
		
			itemList = itemRepository.findAllByOrderByPriceAsc();
		} else if (maxPrice != null) {
		
			itemList = itemRepository.findByPriceLessThanEqual(maxPrice);
		} else if (keyword.length() > 0) {
		
			itemList = itemRepository.findByNameContaining(keyword);
		} else
			itemList = itemRepository.findAll();
		
		model.addAttribute("maxPrice", maxPrice);
		model.addAttribute("keyword", keyword);
		model.addAttribute("items", itemList);
		
		return "items";
		}*/

		List<Item> itemList = null;

		if (categoryId != null) {
			itemList = itemRepository.findByCategoryId(categoryId);
		}

		else if (keyword.length() > 0) {

			if (maxPrice != null) {

				if (sort.equals("priceAsc")) {
					itemList = itemRepository.findByNameContainingAndPriceLessThanEqualOrderByPriceAsc(keyword,
							maxPrice);
				} else {
					itemList = itemRepository.findByNameContainingAndPriceLessThanEqual(keyword, maxPrice);
				}
			} else {

				if (sort.equals("priceAsc")) {
					itemList = itemRepository.findByNameContainingOrderByPriceAsc(keyword);
				} else {
					itemList = itemRepository.findByNameContaining(keyword);
				}
			}

		} else {

			if (maxPrice != null) {

				if (sort.equals("priceAsc")) {
					itemList = itemRepository.findByPriceLessThanEqualOrderByPriceAsc(maxPrice);
				} else {
					itemList = itemRepository.findByPriceLessThanEqual(maxPrice);
				}
			} else {

				if (sort.equals("priceAsc")) {
					itemList = itemRepository.findAllByOrderByPriceAsc();
				} else {
					itemList = itemRepository.findAll();
				}
			}
		}

		model.addAttribute("maxPrice", maxPrice);
		model.addAttribute("keyword", keyword);

		model.addAttribute("items", itemList);
		return "items";
	}
}
