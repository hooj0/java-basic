package io.github.hooj0.collection.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SynchronizedTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Jan 14, 2011 9:31:07 PM
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Collection<String> c = Collections.synchronizedCollection(new ArrayList<String>());
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		Set<String> set = Collections.synchronizedSet(new HashSet<String>());
		Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
		Map<String, String> sortMap = Collections.synchronizedSortedMap(new TreeMap<String, String>());
		Set<String> sortSet = Collections.synchronizedSortedSet(new TreeSet<String>());
	}
}
