package com.lou.simhasher;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
* @author louxuezheng@hotmail.com
*/
public class SimhashTest {
	
	@Test
	public void testDistance(){
		String str1 = readAllFile("D:/test/testin.txt");
		SimHasher hash1 = new SimHasher(str1);
		//打印simhash签名
		System.out.println(hash1.getSignature());
		System.out.println("============================");

		String str2 = readAllFile("D:/test/testin2.txt");
		//打印simhash签名
		SimHasher hash2 = new SimHasher(str2);
		System.out.println(hash2.getSignature());
		System.out.println("============================");

		//打印海明距离
		System.out.println(hash1.getHammingDistance(hash2.getSignature()));
		
	}
	
	/**
	 * 测试用
	 * @param filename 名字
	 * @return
	 */
	public static String readAllFile(String filename) {
		String everything = "";
		try {
			FileInputStream inputStream = new FileInputStream(filename);
			everything = IOUtils.toString(inputStream);
			inputStream.close();
		} catch (IOException e) {
		}

		return everything;
	}
}
