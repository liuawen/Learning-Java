package cn.mldn.microboot.base.test;

import cn.mldn.microboot.util.PasswordUtil;

public class TestPassword {
	public static void main(String[] args) {
		System.out.println(PasswordUtil.encoder("hello"));
	}
}
