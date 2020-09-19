package list.indexedListUse;

import java.util.ArrayList;
import java.util.List;

/**
 * Josephus问题是指列表不按顺序取出而是每隔i个元素提取一个时，
 * 
 * @author Wangxy
 *
 */
public class JosephusProblem {

	public static void main(String[] args) {
		int numPeople = 7;
		int skip = 2;
		int targetIndex;
		List<String> list = new ArrayList<String>();
		// 初始化list
		for (int count = 1; count <= numPeople; count++) {
			list.add("Soldier " + count);
		}
		System.out.println(list);

		targetIndex = skip;
		while (!list.isEmpty()) {
			System.out.println(list.remove(targetIndex));// 移出
			if (list.size() > 0) {
				targetIndex = (targetIndex + skip) % list.size();
			}
		}

	}
}
