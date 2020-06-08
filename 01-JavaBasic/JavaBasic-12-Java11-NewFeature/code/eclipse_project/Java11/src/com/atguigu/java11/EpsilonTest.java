package com.atguigu.java11;

import java.util.ArrayList;
import java.util.List;

class Garbage {
	
	private double d1 = 1;
	private double d2 = 2;
	
	// 这个方法是GC在清除本对象时, 会调用一次
	@Override
	public void finalize() {
		System.out.println(this + " collecting");
	}
}

public class EpsilonTest {
	
	// 执行: -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
	public static void main(String[] args) {
		List<Garbage> list = new ArrayList<>();
		boolean flag = true;
		int count = 0;
		while (flag) {
			list.add(new Garbage());
			if (count++ == 500) {
				list.clear();
			}
		}
	}
}
