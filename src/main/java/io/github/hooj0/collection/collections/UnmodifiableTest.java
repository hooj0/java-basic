package io.github.hooj0.collection.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 不可变集合测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:49:13
 */
public class UnmodifiableTest {

	public static void main(String[] args) {
		//创建一个空的不可变的List对象
		List<String> emptyList = Collections.emptyList();
		
		//创建一个只有一个元素、且不可变的Set对象
		Set<String> unmodifiableSet = Collections.singleton("Java");
		
		//创建一个普通Map
		Map<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("语文", 60);
		scores.put("Java", 90);
		
		Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(scores);
		//测试数据是否可以添加，java.lang.UnsupportedOperationException不可变的
		emptyList.add("test");
		unmodifiableSet.add("DB");
		unmodifiableMap.put("高数", 88);
	}
}
