package io.github.hooj0.reflection.proxy;

/**
 * 杀手有杀人的本领，他可以随意杀人
 * @author hoojo
 * @createDate Oct 6, 2010 5:28:58 PM
 * @file Killer.java
 * @package com.hoo.base.proxy
 * @project JavaReflection
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class Killer extends KillPerson {

	/**
	 * @see com.hoo.base.proxy.KillPerson#killPerson(String)
	 *  杀手学到了杀人的方法
	 * @author hoojo
	 * @createDate Oct 6, 2010 5:30:30 PM
	 */
	public void killPerson(String name) {
		System.out.println("kill people for name is " + name);
	}
}
