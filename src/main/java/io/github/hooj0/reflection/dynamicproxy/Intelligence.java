package io.github.hooj0.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <b>function:</b> 情报人员——线人
 * @author hoojo
 * @createDate Oct 6, 2010 5:59:33 PM
 * @file Intelligence.java
 * @package com.hoo.base.dynamicproxy
 * @project JavaReflection
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class Intelligence implements InvocationHandler {
	/**
	 * 从哪里获得情报，目标对象
	 */
	private Object target;
	/**
	 * 线人都有的条件和技能
	 */
	private SkillHelper sh;
	public Intelligence(SkillHelper sh) {
		this.sh = sh;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//介绍个人技能
		sh.individualSkill();
		//首先混入匪窝
		sh.interfuseDen();
		//赢得匪头儿的信任
		sh.gainFaith();
		//执行命令
		Object result = method.invoke(target, args);
		//送出情报后，得到钱
		sh.getMoney();
		return result;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
}
