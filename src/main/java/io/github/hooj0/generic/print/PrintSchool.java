package io.github.hooj0.generic.print;


import io.github.hooj0.generic.enums.Student;

/**
 * 打印学校
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 16, 2010 2:21:38 PM
 */
public class PrintSchool {

	public static void main(String[] args) {
		int i = 0;
		for (Student s : Student.values()) {
			System.out.printf("%s%n\t%s%n", ++i, s);
		}
	}

}
