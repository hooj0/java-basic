package io.github.hooj0.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	/**
	 *
	 * set无序、不容许重复元素
	 * HashSet、TreeSet、EnumSet线程不安全
	 * 当用多线程操作的时候，要用synchronizedSortedSet包装Set集合
	 * SortedSet set = Collections.synchronizedSortedSet(new TreeSet(...));
	 * @author hoojo
	 * @createDate Jan 9, 2011 3:24:05 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> books = new HashSet<String>();
		books.add("Struts");
		//添加相同的内容，添加失败
		boolean bo = books.add("Struts");		
		System.out.println(bo);
	}
	/**
	 * hashSet无序、不可重复，hashset表面上没有索引，实际上每个元素都有一个
	 * 索引，其索引是hashCode值，按照hashCode的值排列顺序
	 * 
	 * 不同类型属性的HashCode取值方式
	 * boolean hashCode=(f?0:1)
	 * 整数类型(byte、short、char、int) hashCode=(int)f;
	 * long hashCode=(int)(f^(f>>>32))
	 * float hashCode=Float.floatToIntBits(f);
	 * double long l = Double.doubleToLongBits(f);
	 * 			hashCode=(int)(l^(l>>>32));
	 * 普通引用类型
	 * hashCode=f.hashCode();
	 */
}
