package io.github.hooj0.generic.enumcollection;

import io.github.hooj0.generic.enums.Student;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * EnumMap
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 16, 2010 2:49:36 PM
 */
public class EnumMapTest {

	public static void main(String[] args) {
		Map<Student, String> map = new EnumMap<Student, String>(Student.class);
		map.put(Student.TEN, "第十");
		map.put(Student.ONE, "第一");
		map.put(Student.TWO, "第二");
		for (Student s : Student.values()) {
			System.out.println(map.get(s));
		}
		/**
		 * 从遍访的结果可以看出，对象的順序是根据枚举順序來排列的
		 */
		
		for (String s : map.values()) {
			System.out.println(s);
		}
		
		Set<Student> set = map.keySet();
		for (Iterator<Student> iter = set.iterator();iter.hasNext();) {
			System.out.println(iter.next().getName());
		}
	}
}
