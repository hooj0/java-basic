package io.github.hooj0.reflection.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 *  情报工厂代理
 * @author hoojo
 * @createDate Oct 6, 2010 7:01:54 PM
 * @file InformactionProxyFactory.java
 * @package com.hoo.base.dynamicproxy
 * @project JavaReflection
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class InformactionProxyFactory {

	/**
	 * 传入一个线人和一个劫匪
	 * @author hoojo
	 * @createDate Oct 6, 2010 7:39:59 PM
	 * @param helper
	 * @param info
	 * @return GatherInformation
	 */
	public static Object getInformaction(SkillHelper helper, GatherInformation info) {
		Intelligence handler = new Intelligence(helper);
		handler.setTarget(info);
		return Proxy.newProxyInstance(info.getClass().getClassLoader(), info.getClass().getInterfaces(), handler);
	}
}
