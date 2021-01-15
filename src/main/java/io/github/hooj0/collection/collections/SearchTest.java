package io.github.hooj0.collection.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SearchTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 14, 2011 8:58:55 PM
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		
		System.out.println(nums);
		//输出最大的元素
		System.out.println("max:" + Collections.max(nums));
		//输出最小的元素
		System.out.println("min:" + Collections.min(nums));
		
		//将nums中的0使用1来代替
		Collections.replaceAll(nums, 0, 1);
		System.out.println("replace:" + nums);
		
		//判断-5在nums中出现次数
		System.out.println("count:" + Collections.frequency(nums, -5));
		
		//对nums集合排序
		Collections.sort(nums);
		System.out.println("sort:" + nums);
		
		//只有排序后的集合才能用二分法查询，输出3
		System.out.println(Collections.binarySearch(nums, 3));
	}
}
