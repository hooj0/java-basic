package io.github.hooj0.network.udp.multicast.chat;

import java.net.SocketAddress;

/**
 * 用户基本信息
 *
 * @author hoojo
 * @version 1.0
 * @createDate Sep 23, 2010 5:47:06 PM
 * @file UserInfo.java
 * @package com.hoo.base.udp.multicast.chart
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
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
        return this.chatFrame;
    }

    public void setChatFrame(ChatFrame chartFrame) {
        this.chatFrame = chartFrame;
        this.chatFrame.setTitle("和" + this.userName + "聊天中");
    }

    public UserInfo() {
    }

    public UserInfo(String icon, String userName, SocketAddress address, int lost) {
        this.icon = icon;
        this.userName = userName;
        this.address = address;
        this.lost = lost;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SocketAddress getAddress() {
        return this.address;
    }

    public void setAddress(SocketAddress address) {
        this.address = address;
    }

    public int getLost() {
        return this.lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass() == UserInfo.class) {
            return ((UserInfo) o).getAddress().equals(this.address);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }
}
