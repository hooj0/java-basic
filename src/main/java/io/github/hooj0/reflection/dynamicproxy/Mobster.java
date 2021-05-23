package io.github.hooj0.reflection.dynamicproxy;

/**
 * <b>function:</b>匪徒
 * @author hoojo
 * @createDate Oct 6, 2010 5:56:03 PM
 * @file Mobster.java
 * @package com.hoo.base.dynamicproxy
 * @project JavaReflection
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class Mobster implements GatherInformation {
	private String name;
	public Mobster(String name) {
		this.name = name;
	}
	/**
	 * @see com.hoo.base.dynamicproxy.GatherInformation#message(String)
	 * <b>function:</b> 匪徒放出的消息，真实的情报
	 * @author hoojo
	 * @createDate Oct 6, 2010 5:56:30 PM
	 */
	public void message(String msg) {
		System.out.println(name + "劫匪的真实情报：" + msg);
	}
}
