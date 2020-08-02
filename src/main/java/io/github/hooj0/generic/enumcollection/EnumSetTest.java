package io.github.hooj0.generic.enumcollection;

import io.github.hooj0.generic.enums.Student;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * 枚举集测试
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 16, 2010 2:28:16 PM
 */
public class EnumSetTest {

	public static void main(String[] args) {
		EnumSet<Student> set = EnumSet.of(Student.EIGHT, Student.NINE);
		showSet(set);
		System.out.println("###################");
		showSet(EnumSet.complementOf(set));//Student.EIGHT, Student.NINE这2个元素就不会出现
		System.out.println("###################");
		showSet(EnumSet.range(Student.TWO, Student.SIX));//返回Student.TWO 到 Student.SIX的元素
	}
	
	public static void showSet(EnumSet<Student> set) {
		Iterator<Student> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().getName());
		}
	}
}
