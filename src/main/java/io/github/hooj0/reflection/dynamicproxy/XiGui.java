package io.github.hooj0.reflection.dynamicproxy;

/**
 * 线人——细鬼（谢霆锋饰演）；每个线人都有这些技能
 * @author hoojo
 * @createDate Oct 6, 2010 6:26:56 PM
 * @file XiGui.java
 * @package com.hoo.base.dynamicproxy
 * @project JavaReflection
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class XiGui implements SkillHelper, GatherInformation {

	public void gainFaith() {
		System.out.println("赢得华天的信任！");
	}

	public void getMoney() {
		System.out.println("警察给报酬100万！");
	}

	public void individualSkill() {
		System.out.println("个人技能：飙车！");
	}

	public void interfuseDen() {
		System.out.println("飙车赛，混入匪窝！");
	}
	
	/**
	 * @see com.hoo.base.dynamicproxy.GatherInformation#message(String)
	 *  收集情报
	 * @author hoojo
	 * @createDate Oct 6, 2010 7:25:47 PM
	 */
	public void message(String msg) {
		System.out.println("接到通知:" + msg);
		System.out.println("细鬼开始收集情报");
		//劫匪
		GatherInformation mobster = new Mobster("老大华天");
		/**
		 * 情报工厂，细鬼是线人，Mobster是劫匪；
		 * 线人从劫匪那里获取情报
		 */
		GatherInformation information = (GatherInformation) InformactionProxyFactory.getInformaction(this, mobster);
		//劫匪发出情报
		information.message("抢劫金店！");
	}
}
