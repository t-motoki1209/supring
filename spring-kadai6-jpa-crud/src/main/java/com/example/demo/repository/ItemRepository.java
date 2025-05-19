package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByCategoryId(int categoryId);

	List<Item> findAllByOrderByPriceAsc();

	List<Item> findByPriceLessThanEqual(Integer maxPrice);

	List<Item> findByNameContaining(String keyword);

}
