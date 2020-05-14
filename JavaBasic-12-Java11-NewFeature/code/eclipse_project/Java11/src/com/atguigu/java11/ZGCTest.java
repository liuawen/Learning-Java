package com.atguigu.java11;

import java.util.ArrayList;
import java.util.List;


public class ZGCTest {
	
	// Ö´ÐÐ: -XX:+UnlockExperimentalVMOptions -XX:+UseZGC
	public static void main(String[] args) {
		List<Garbage> list = new ArrayList<>();
		boolean flag = true;
		int count = 0;
		while (flag) {
			list.add(new Garbage());
			if (count++ % 500 == 0) {
				list.clear();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
