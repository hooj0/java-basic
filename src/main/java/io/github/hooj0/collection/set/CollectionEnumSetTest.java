package io.github.hooj0.collection.set;

import io.github.hooj0.collection.base.Season;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;


public class CollectionEnumSetTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 9, 2011 6:43:06 PM
	 * @param args
	 */
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
