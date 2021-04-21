package io.github.hooj0.generic.enums;

public class ShowEnum {
	public static void main(String[] args) {
		//printEnum(Color.valueOf("RED"));
		//printEnum(Color.valueOf("WHITE"));
		printEnum2(Student.valueOf("SEVEN"));//相当于Class.forName("package.class");通过字符串找到一个枚举对象
		printEnum2(Student.EIGHT);
	}
	
	public static void printEnum(Color c) {
		System.out.println(c);
		for (Color color : Color.values()) {
			System.out.println(color + " = " + color.compareTo(c) + " # " + c.compareTo(color));
		}
	}
	
	public static void printEnum2(Student s) {
		System.out.println(s);
		for (Student st : Student.values()) {
			System.out.println("[" + st + ":" + st.getName() + "] = " + st.compareTo(s) + " # " + s.compareTo(st));
		}
	}
}
