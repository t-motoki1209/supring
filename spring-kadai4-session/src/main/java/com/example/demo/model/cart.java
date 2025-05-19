package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class cart {

	private List<item> items = new ArrayList<>();

	public List<item> getItems() {

		return items;
	}

}
