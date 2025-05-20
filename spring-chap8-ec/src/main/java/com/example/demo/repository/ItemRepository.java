package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	// SELECT * FROM items WHERE category_id = ?
	List<Item> findByCategoryId(Integer categoryId);

	List<Item> findAllByOrderByPriceAsc();

	List<Item> findByPriceLessThanEqual(Integer maxPrice);

	List<Item> findByNameContaining(String keyword);

	List<Item> findByNameContainingAndPriceLessThanEqualOrderByPriceAsc(String keyword, Integer maxPrice);

	List<Item> findByNameContainingAndPriceLessThanEqual(String keyword, Integer maxPrice);

	List<Item> findByNameContainingOrderByPriceAsc(String keyword);

	List<Item> findByPriceLessThanEqualOrderByPriceAsc(Integer maxPrice);
}
