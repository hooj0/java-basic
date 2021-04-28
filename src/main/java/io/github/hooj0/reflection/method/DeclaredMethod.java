package io.github.hooj0.reflection.method;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 得到某个类的所有方法
 * @author hoojo
 * @createDate Oct 5, 2010 3:31:32 PM
 * @file DeclaredMethod.java
 * @package com.hoo.base.method
 * @project JavaReflection
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DeclaredMethod {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class<?> clazz = Class.forName(sc.next());
		Method[] methods = clazz.getDeclaredMethods();

		for (Method m : methods) {
			System.out.println(m.toString() + "###" + m.toGenericString());
		}
	}
}
