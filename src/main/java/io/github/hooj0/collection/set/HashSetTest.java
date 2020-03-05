package io.github.hooj0.collection.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 散列集测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 9, 2011 6:22:01 PM
 */
public class HashSetTest {

	public static void main(String[] args) {
		HashSet<R> set = new HashSet<R>();
		set.add(new R(5));
		set.add(new R(-3));
		set.add(new R(9));
		set.add(new R(-2));
		
		System.out.println(set);
		//拿出第一个元素
		Iterator<R> iter = set.iterator();
		R first = iter.next();
		//为第一个元素赋值
		first.count = -3;
		System.out.println(set);
		set.remove(new R(-3));
		System.out.println(set);
		System.out.println("包含count为-3的R对象? " + set.contains(new R(-3)));
		System.out.println("包含count为5的R对象? " + set.contains(new R(5)));
	}
}

class R {
	int count;
	public R(int count) {
		this.count = count;
	}
	
	public String toString() {
		return "R(count属性：" + this.count + ")";
	}
	
	public boolean equals(Object o) {
		if (o instanceof R) {
			R r = (R) o;
			if (r.count == this.count) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return this.count;
	}
}