package io.github.hooj0.collection.map;

import java.util.TreeMap;

public class TreeMapTest {

	/**
	 *
	 * @author hoojo
	 * @createDate Jan 12, 2011 11:04:48 PM
	 * @param args
	 * TreeMap是处于红黑树算法，将key进行排序，从而保证key始终处于有序状态
	 * 自然排序：TreeMap的所有可以必须实现Comparable接口，而且所有的key应该是同一个类型
	 * 否则会出现ClassCastException
	 * 定制排序：创建TreeMap时，传入一个Comparator对象，该对象负责对TreeMap中所有的key进行排序
	 * 采用定制排序时不需要Map的key实现Comparable接口
	 * 
	 * TreeMap在插入、删除数据的时候，速度很慢；因为通过TreeMap红黑树维护key的次序
	 * 
	 * TreeMap判断key相等是通过equals方法比较返回true就相等
	 * 而通过compareTo方法返回0，TreeMap即认为key相等
	 */
	public static void main(String[] args) {
		TreeMap<R, String> tm = new TreeMap<R, String>();
		tm.put(new R(3), "JavaEE");
		tm.put(new R(-5), "Struts");
		tm.put(new R(0), "Spring");
		tm.put(new R(-1), "Hibernate");
		tm.put(new R(9), "JavaME");
		tm.put(new R(2), "Lucene");
		System.out.println(tm);
		
		System.out.println(tm.lastKey());
		//返回该TreeMap的比new R(2)大的最小key值
		System.out.println(tm.higherKey(new R(2)));
		
		//返回该TreeMap的比new R(2)小的最大的key-value键值对
		System.out.println(tm.lowerEntry(new R(2)));
		
		//返回当前TreeMap的子TreeMap
		System.out.println(tm.subMap(new R(-3), new R(4)));
	}
}

@SuppressWarnings("unchecked")
class R implements Comparable {
	int count;
	
	public R(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "R(count: " + this.count + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o != null && o.getClass() == R.class) {
			R r = (R) o;
			if (r.count == this.count) {
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(Object o) {
		R r = (R) o;
		if (this.count > r.count) {
			return 1;
		} else if (this.count == r.count) {
			return 0;
		} else {
			return -1;
		}
	}
}
