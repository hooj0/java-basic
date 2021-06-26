package io.github.hooj0.generic.enums;

public enum Student {
	/**
	 * 下面每个枚举元素，相当于当前枚举Student的一个实例。括号中的相当于实例的构造，传递的参数
	 * new Student("参数")
	 */
	ONE("胡一"), TWO("桃二"), THREE("张三"), FOUR("李四"), FIVE("王五"), SIX("找六"), SEVEN("李七"), EIGHT("孙八"), NINE("洪九"), TEN("朱十");
	
	private String name;
	public String getName() {
		return this.name;
	}
	
	/**
	 * 枚举构造函数，修饰符可以省略。只能是私有
	 * @param name
	 */
	private Student(String name) {
		this.name = name;
	}
	/*Student(String name) {
		this.name = name;
	}*/
	
	
	/*{
		System.out.println("执行");//执行十二次，说明每次初始化都允许普通初始块
	}*/
	
	public static void main(String[] args) {
		Student stu = Student.ONE;
		System.out.println(stu.getName());
		
		Student stu2 = Student.TEN;
		System.out.println(stu2.getName());
		//Student.TEN = Student.FIVE;//final
		
		for (Student s : Student.values()) {
			System.out.println(s + "-" + s.getName());
		}
	}
	/**
	 * 当您使用“enum”定义 枚举类型时，实质上您定义出來的类型继承自 java.lang.Enum 类型，
	 * 而每个枚举的成员其实就是您定义的枚举类型的一個实例（Instance），他们都被预设为 final，
	 * 所以您无法改变他们，他们也是 static 成員，所以您可以通过类型名称直接使用他们，
	 * 当然最重要的，它們都是公开的（public）
	 */
}
