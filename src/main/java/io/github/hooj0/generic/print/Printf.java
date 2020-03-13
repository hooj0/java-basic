package io.github.hooj0.generic.print;

import io.github.hooj0.generic.enums.Student;

/**
 * printf
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:26:44
 */
public class Printf {

	public static void main(String[] args) {
		int i = 0;
		for (Student s : Student.values()) {
			System.out.printf("%d, \t%s%n", i, s.getName());
			/**
			 * %d指向参数i
			 * \t是tab位
			 * %s指向参数s.getName()
			 * %n相当于\n
			 */
			++i;
		}
	}
}
