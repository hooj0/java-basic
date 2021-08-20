package io.github.hooj0.collection.set;

import java.util.TreeSet;

public class TreeSetTest2 {

	/**
	 *
	 * @author hoojo
	 * @createDate Jan 9, 2011 5:46:15 PM
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<R2> t = new TreeSet<R2>();
		t.add(new R2(5));
		t.add(new R2(-3));
		t.add(new R2(9));
		t.add(new R2(-2));
		System.out.println(t);
		
		R2 first = (R2) t.first();
		first.count = 20;
		
		R2 last = (R2) t.last();
		last.count = -2;
		
		System.out.println(t);
		t.remove(new R2(-2));//删除失败
		System.out.println(t);
		t.add(new R2(5));
		System.out.println(t);
	}
}

@SuppressWarnings("unchecked")
class R2 implements Comparable {
	int count;
	public R2(int count) {
		this.count = count;
	}
	
	public String toString() {
		return "R(count属性：" + this.count + ")";
	}
	
	public boolean equals(Object o) {
		if (o instanceof R2) {
			R2 r = (R2) o;
			if (r.count == this.count) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return this.count;
	}

	public int compareTo(Object o) {
		R2 r = (R2) o;
		if (this.count > r.count) {
			return 1;
		} else if (this.count == r.count) {
			return 0;
		} else {
			return -1;
		}
	}
}
