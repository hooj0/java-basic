package io.github.hooj0.collection.list;

import java.util.Arrays;
import java.util.List;

/**
 * 固定大小列表
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 10, 2011 9:50:20 PM
 */
public class FixedSizeList {

	public static void main(String[] args) {
		List<String> fixedList = Arrays.asList("Struts2", "Java Base");
		System.out.println(fixedList.getClass());
		for (int i = 0; i < fixedList.size(); i++) {
			System.out.println(fixedList.get(i));
		}
		
		//fixedList.add("RIA");//这里将出现异常，因为这里的List长度是固定的
		//fixedList.remove("Struts2");
		
		System.out.println(fixedList);
	}
}
