package com.example.demo.quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("お金を入れてください：");
		int money = scan.nextInt();
		//判定処理
		int back = money - 120;
		if (money < 120) {
			System.out.print("お金が足りません：");
		} else if (money > 120) {
			System.out.print("購入できましたお釣りは" + back + "円です。");
		} else {
			System.out.print("購入できました");
		}

		scan.close();

	}
}
