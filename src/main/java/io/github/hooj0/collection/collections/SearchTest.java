package io.github.hooj0.collection.collections;

import io.github.hooj0.BasedTests;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 搜索测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 14, 2011 8:58:55 PM
 */
public class SearchTest extends BasedTests {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		
		out(nums);
		//输出最大的元素
		out("max:" + Collections.max(nums));
		//输出最小的元素
		out("min:" + Collections.min(nums));
		
		//将nums中的0使用1来代替
		Collections.replaceAll(nums, 0, 1);
		out("replace:" + nums);
		
		//判断-5在nums中出现次数
		out("count:" + Collections.frequency(nums, -5));
		
		//对nums集合排序
		Collections.sort(nums);
		out("sort:" + nums);
		
		//只有排序后的集合才能用二分法查询，输出3
		out(Collections.binarySearch(nums, 3));
	}
}
