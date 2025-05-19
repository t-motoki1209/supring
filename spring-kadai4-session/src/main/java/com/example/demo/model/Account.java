package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Account {
	private String name;

	public Account() {
	}

	public Account(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return this.name;

	}

}
