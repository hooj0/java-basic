package io.github.hooj0.network.udp.multicast.chart;

import java.net.SocketAddress;

/**
 * <b>function:</b> 用户基本信息
 * @author hoojo
 * @createDate Sep 23, 2010 5:47:06 PM
 * @file UserInfo.java
 * @package com.hoo.base.udp.multicast.chart
 * @project JavaNetBase
 * @blog http:blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class UserInfo {
	//用户图片
	private String icon;
	//用户名称
	private String userName;
	//用户的ip和端口信息
	private SocketAddress address;
	//失去练习次数
	private int lost;
	//该用户对应的交谈窗口
	private ChatFrame chatFrame;
	
	public ChatFrame getChatFrame() {
		return chatFrame;
	}

	public void setChatFrame(ChatFrame chartFrame) {
		this.chatFrame = chartFrame;
		this.chatFrame.setTitle("和" + this.userName + "聊天中");
	}
	
	public UserInfo() {}
	
	public UserInfo(String icon, String userName, SocketAddress address, int lost) {
		this.icon = icon;
		this.userName = userName;
		this.address = address;
		this.lost = lost;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public SocketAddress getAddress() {
		return address;
	}
	public void setAddress(SocketAddress address) {
		this.address = address;
	}
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}

	public boolean equals(Object o) {
		if (o != null && o.getClass() == UserInfo.class) {
			return ((UserInfo)o).getAddress().equals(address);
		}
		return false;
	}

	public int hashCode() {
		return address.hashCode();
	}
}
