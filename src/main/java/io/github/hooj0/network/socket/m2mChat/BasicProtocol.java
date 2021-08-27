package io.github.hooj0.network.socket.m2mChat;

/**
 * <b>function:</b> 自定义通讯协议规则 常量字符串
 * @author hoojo
 * @createDate Sep 23, 2010 11:01:41 AM
 * @file BasicProtocol.java
 * @package com.hoo.base.socket.m2mChat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public interface BasicProtocol {
	//定义协议字符串的长度
	int PROTOCOL_LENGHT = 2;
	//下面是一些协议特殊字符串，用于服务器端和客户端交互信息
	//都要在前、后添加协议字符串
	String MSG_ROUND = "§ⅴ";
	String USER_ROUND = "Ⅱ∑";
	String LOGIN_SUCCESS = "1";
	String NAME_REP = "-1";
	String PRIVATE_ROUND = "★【";
	String SPLIT_SIGN = "※";
}
