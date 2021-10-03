package io.github.hooj0.reflection.method;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodReflectTester {
	public Object copy(Object o) throws Exception {
		Class<?> clazz = o.getClass();
		System.out.println("Class:" + clazz.getName());
		
		//Object copyObject = clazz.newInstance();
		Object copyObject = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
		
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			String fieldName = f.getName();
			String firstChar = fieldName.substring(0, 1).toUpperCase();
			String setMethodName = "set".concat(firstChar).concat(fieldName.substring(1));
			String getMethodName = "get".concat(firstChar).concat(fieldName.substring(1));
			System.out.println("setter:" + setMethodName);
			System.out.println("getter:" + getMethodName);
			
			Method getMethod = clazz.getMethod(getMethodName, new Class[]{});
			Method setMethod = clazz.getMethod(setMethodName, new Class[]{f.getType()});
			
			Object getVal = getMethod.invoke(o, new Object[]{});
			System.out.println(fieldName + ":" + getVal);
			//调用copyObject的setter方法 
			setMethod.invoke(copyObject, new Object[]{getVal});
		}
		return copyObject;
	}
	
	public static void main(String[] args) throws Exception {
		MethodReflectTester test = new MethodReflectTester();
		User o = new User();
		o.setAge(22);
		o.setId(2L);
		o.setName("jack");
		User u = (User) test.copy(o);
		System.out.println(u);
	}
}

class User {
	private long id;
	private String name;
	private int age;
	public User() {
	}
	public User(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return id + ", " + age + ", " + name;
	}
}
