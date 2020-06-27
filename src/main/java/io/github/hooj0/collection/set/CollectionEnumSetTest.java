package io.github.hooj0.collection.set;

import io.github.hooj0.collection.base.Season;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;


/**
 * 集合枚举集测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 9, 2011 6:43:06 PM
 */
public class CollectionEnumSetTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.clear();
		c.add(Season.FALL);
		c.add(Season.SPRING);
		
		EnumSet<Season> es = EnumSet.copyOf(c);
		System.out.println(es);
		//c.add("abc");
		//c.add("Java");
		es = EnumSet.copyOf(c);
		System.out.println(c);
	}
}
