package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service

public class RandomStringService {

	public List<String> generate(int charLength, boolean withNumber) {
		// TODO 自動生成されたメソッド・スタブ
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			//
			if (withNumber) {
				list.add(RandomStringUtils.randomAlphanumeric(charLength));

			} else {
				list.add(RandomStringUtils.randomAlphanumeric(charLength));

			}
		}
		return list;
	}

}
