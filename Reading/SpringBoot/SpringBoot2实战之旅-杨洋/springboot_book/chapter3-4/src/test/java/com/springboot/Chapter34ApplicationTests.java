package com.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter34ApplicationTests {

	@Value("${book.name}")
	private String bookName;

	@Value("${book.author}")
	private String bookAuthor;

	@Test
	public void test1() {
		Assert.assertEquals(bookName, "SpringBoot2实战之旅");
		Assert.assertEquals(bookAuthor, "杨洋");
	}

}
