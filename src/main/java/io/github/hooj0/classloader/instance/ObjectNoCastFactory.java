package io.github.hooj0.classloader.instance;

import java.util.Date;

public class ObjectNoCastFactory {
	public static <T> T getInstance(Class<T> clazz) {
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static void main(String[] args) {
		//使用泛型无需转换
		Date d = ObjectNoCastFactory.getInstance(Date.class);
		User u = ObjectNoCastFactory.getInstance(User.class);
		System.out.println(d);
		System.out.println(u);
	}
}
