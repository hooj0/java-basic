package io.github.hooj0.collection.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Jan 14, 2011 8:43:16 PM
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		
		System.out.println(nums);
		
		//排序
		Collections.sort(nums);
		System.out.println(nums);
		
		//翻转次序
		Collections.reverse(nums);
		System.out.println(nums);
		
		//随机排序
		Collections.shuffle(nums);
		System.out.println(nums);
	}
}
