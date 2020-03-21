package io.github.hooj0.collection.collections;

import io.github.hooj0.BasedTests;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 排序测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 14, 2011 8:43:16 PM
 */
public class SortTest extends BasedTests {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		
		out(nums);
		
		//排序
		Collections.sort(nums);
		out(nums);
		
		//翻转次序
		Collections.reverse(nums);
		out(nums);
		
		//随机排序
		Collections.shuffle(nums);
		out(nums);
	}
}
