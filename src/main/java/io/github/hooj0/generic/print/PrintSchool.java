package io.github.hooj0.generic.print;


import io.github.hooj0.generic.enums.Student;

public class PrintSchool {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 16, 2010 2:21:38 PM
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		for (Student s : Student.values()) {
			System.out.printf("%s%n\t%s%n", ++i, s);
		}
	}

}
