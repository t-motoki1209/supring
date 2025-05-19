package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	/*@GetMapping({ "/", "/items" })
	public String index(Model model) {
		//データベースからすべてのカテゴリーリストを取得
		List<Category> categoryList = categoryRepository.findAll();
		//データベースから商品リストを取得
		List<Item> list = itemRepository.findAll();
		//取得したしょうひんりすとをデータ置き場にいつもどうり
	
		model.addAttribute("categories", categoryList);
		model.addAttribute("items", list);
		//画面遷移
		return "items";
	}*/
	@GetMapping({ "/", "/items" })
	public String index(@RequestParam(name = "categoryId", defaultValue = "0") int categoryId,
			Model model) {

		// categoryテーブルから全カテゴリー一覧を取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);
		List<Item> itemList = null;

		if (categoryId != 0) {
			// itemsテーブルをカテゴリーIDを指定して一覧を取得
			itemList = itemRepository.findByCategoryId(categoryId);
		}

		else {
			// 全商品検索
			itemList = itemRepository.findAll();
		}

		model.addAttribute("items", itemList);
		return "items";
	}

	@GetMapping("/items/add")
	public String create() {
		return "addItem";
	}

	@PostMapping("/items/add")
	public String store(

			@RequestParam(name = "categoryId", defaultValue = "0") int categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "0") int price) {

		Item item = new Item(categoryId, name, price);
		itemRepository.save(item);

		return "redirect:/items";
	}

	@GetMapping("/items/{id}/edit")
	public String edit(@PathVariable("id") Integer id,
			Model model) {
		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);

		return "editItem";
	}

	@PostMapping("/items/{id}/edit")
	public String update(@PathVariable("id") Integer id,

			@RequestParam(name = "categoryId", defaultValue = "0") int categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "0") int price) {
		Item item = itemRepository.findById(id).get();
		item.setCategoryId(categoryId);
		item.setName(name);
		item.setPrice(price);
		itemRepository.save(item);

		return "redirect:/items";

	}

	@PostMapping("/items/{id}/delete")
	public String delete(@PathVariable("id") Integer id) {

		itemRepository.deleteById(id);
		return "redirect:/items";

	}

}
