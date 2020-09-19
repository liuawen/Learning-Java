package queue.useQueue.encrypt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列进行加密解密
 * 
 * @author Wangxy
 *
 */
public class Codes {
	public static void main(String[] args) {
		int[] key = { 5, -1, 6, 3, -4, 3 };
		String encode = "", decode = "";
		int keyValue;
		String message = "There are only two creatures, says a proverb, who can surmount the pyramids the eagle and the snail.";
		Queue<Integer> encodingQueue = new LinkedList<Integer>();
		Queue<Integer> decodingQueue = new LinkedList<Integer>();
		// 加载密钥值
		for (int i = 0; i < key.length; i++) {
			encodingQueue.add(key[i]);
			decodingQueue.add(key[i]);
		}
		// 编码
		for (int scan = 0; scan < message.length(); scan++) {
			keyValue = encodingQueue.remove();
			encode += (char) (message.charAt(scan) + keyValue);
			encodingQueue.add(keyValue);
		}
		// 解码
		for (int scan = 0; scan < encode.length(); scan++) {
			keyValue = decodingQueue.remove();
			decode += (char) (encode.charAt(scan) - keyValue);
			decodingQueue.add(keyValue);
		}
		// 输出结果
		System.out.println("消息：           " + message);
		System.out.println("编码：           " + encode);
		System.out.println("解码：           " + decode);
	}
}
