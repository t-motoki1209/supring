package com.example.demo.model;

public class AccountModel {

	private String name;
	private String mail;
	private String pass;

	public AccountModel() {
	}

	public AccountModel(String name, String mail, String pass) {
		this.name = name;
		this.mail = mail;
		this.pass = pass;

	}

	public String getName() {
		return this.name;

	}

	public String getPass() {
		return this.pass;

	}

	public String getMail() {
		return this.mail;

	}
}
