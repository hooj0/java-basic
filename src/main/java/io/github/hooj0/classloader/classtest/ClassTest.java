package io.github.hooj0.classloader.classtest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class ClassTest {
	private ClassTest() {
		System.out.println("私有方法构造器");
	}
	
	public ClassTest(String name) {
		System.out.println("带参方法构造器 " + name);
	}
	
	public void info() {
		System.out.println("执行info方法");
	}
	
	public void info(String args) {
		System.out.println("执行带参info方法……" + args);
	}
	
	@SuppressWarnings("unused")
	private static String name = "abc";
	public int age = 10;
	
	class Inner{}
	class InnerTest{}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Class<ClassTest> clazz = ClassTest.class;
		//获取ClassTest对象的所有构造器
		Constructor[] ctr = clazz.getDeclaredConstructors();
		System.out.println("classTest的全部构造器：");
		for (Constructor c : ctr) {
			System.out.println(c);
		}
		//获取classTest的全部public构造器
		Constructor[] pubCts = clazz.getConstructors();
		System.out.println("public 构造器：");
		for (Constructor c : pubCts) {
			System.out.println(c);
		}
		//获取该Class对象的全部public方法
		Method[] method = clazz.getMethods();
		System.out.println("所有method方法：");
		for (Method m : method) {
			System.out.println(m);
		}
		//获取当前class指定的方法
		System.out.println("ClassTest 里带有参数的Info方法为：" + clazz.getMethod("info", String.class));
		//获取当前Class对象对应所有类的注释
		Annotation[] anns = clazz.getAnnotations();
		System.out.println("Anneotation注解：");
		for (Annotation a : anns) {
			System.out.println(a);
		}
		System.out.println("Class元素上的@SuppressWarnings注解为：" + clazz.getAnnotation(SuppressWarnings.class));
		
		Field[] field = clazz.getDeclaredFields();
		System.out.println("所有属性：");
		for (Field f : field) {
			System.out.println(f);
		}
		System.out.println("name属性：" + clazz.getField("age"));
		
		//获取当前对象的所有内部类
		Class<?>[] innerClass = clazz.getDeclaredClasses();
		System.out.println("classTest的匿名类：");
		for (Class c : innerClass) {
			System.out.println(c);
		}
		
		Class<?> inClazz = Class.forName("com.hoo.base.classtest.ClassTest$Inner");
		//通过getDeclaringClass方法访问该类对应的外部类
		System.out.println("innerClass的外部类：" + inClazz.getDeclaringClass());
		System.out.println("包名：" + clazz.getPackage());
		System.out.println("父类：" + clazz.getSuperclass());
	}
}
