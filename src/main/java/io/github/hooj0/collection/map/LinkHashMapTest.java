package io.github.hooj0.collection.map;

import java.util.LinkedHashMap;

/**
 * 链接哈希映射表测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 12, 2011 10:40:00 PM
 */
public class LinkHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap<String, Integer> scores = new LinkedHashMap<String, Integer>();
		scores.put("语文", 80);
		scores.put("数学", 76);
		scores.put("英文", 76);
		for (Object key : scores.keySet()) {
			System.out.print(key + "-->");
			System.out.println(scores.get(key));
		}
	}
}
