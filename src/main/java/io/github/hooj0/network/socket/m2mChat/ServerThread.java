package io.github.hooj0.network.socket.m2mChat;

import io.github.hooj0.BasedTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 服务器端一对一，多对多聊天，多线程核心功能
 *
 * @author hoojo
 * @version 1.0
 * @createDate Sep 23, 2010 11:17:33 AM
 * @file ServerThread.java
 * @package com.hoo.base.socket.m2mChat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class ServerThread extends BasedTests implements Runnable {

    private Socket s = null;
    private BufferedReader br = null;
    private PrintStream ps = null;

    //定义一个构造器，接收一个Socket来创建启动线程
    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            //获取当前Socket的输入流
	        this.br = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            //获取当前Socket的输出流
	        this.ps = new PrintStream(this.s.getOutputStream());

            String content = "";
            while ((content = this.br.readLine()) != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String dateTime = sdf.format(new Date());

                //如果读取的数据是以BasicProtocol.USER_ROUND开头和结尾的
                //可以确定读取的是用户登录名
                if (content.startsWith(BasicProtocol.USER_ROUND) && content.endsWith(BasicProtocol.USER_ROUND)) {
                    //得到过滤字符后的消息
                    String userName = this.getFilterMsg(content);
                    //判断用户名是否重复
                    if (ServerHelper.clientMap.containsKey(userName)) {
                        out(dateTime + " 该用户名称已经存在！");
	                    this.ps.println(BasicProtocol.NAME_REP);
                    } else {
                        out(dateTime + "成功登陆！");
	                    this.ps.println(BasicProtocol.LOGIN_SUCCESS);
                        ServerHelper.clientMap.put(userName, this.ps);
                        out("当前用户在线用户" + ServerHelper.clientMap.size() + " 人");
                    }
                }
                //如果读取到的消息是以BasicProtocol.PRIVATE_ROUND开头和结尾的，就是私聊信息；私聊信息只能向指定的输出流发送
                else if (content.startsWith(BasicProtocol.PRIVATE_ROUND) && content.endsWith(BasicProtocol.PRIVATE_ROUND)) {
                    //得到过滤处理后的消息
                    String userAndMsg = this.getFilterMsg(content);
                    //以BasicProtocol.SPLIT_SIGN来分割私聊用户名称和发出的信息
                    String[] userAndMsgAry = userAndMsg.split(BasicProtocol.SPLIT_SIGN);
                    String userName = userAndMsgAry[0];
                    String msg = userAndMsgAry[1];

                    BasicMap<String, PrintStream> clientMap = ServerHelper.clientMap;
                    //获取私聊用户的输出流，并发送消息
                    clientMap.get(userName).println(clientMap.getKeyByVal(this.ps) + "  " + dateTime + "  悄悄地对你说: " + msg);
                }
                //公聊
                else {
                    //得到处理后的消息
                    String msg = this.getFilterMsg(content);

                    //向 ServerHelper.clientMap中的每个用户发送消息
                    for (PrintStream clientPs : ServerHelper.clientMap.valueSet()) {
                        clientPs.println(ServerHelper.clientMap.getKeyByVal(this.ps) + "  " + dateTime + " 说: " + msg);
                    }
                }
            }
        } catch (IOException e) {
            //发生异常表明客户端的Socket出现了连接问题
            //删除当前的输出流
            ServerHelper.clientMap.remvoeByVal(this.ps);
            out("当前用户在线用户" + ServerHelper.clientMap.size() + " 人");
            try {
                if (this.br != null) {
	                this.br.close();
                }
                if (this.ps != null) {
	                this.ps.flush();
	                this.ps.close();
                }
                if (this.s != null && !this.s.isClosed()) {
	                this.s.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //读取过滤后的消息，去掉特殊字符串
    private String getFilterMsg(String msg) {
        return msg.substring(BasicProtocol.PROTOCOL_LENGHT, msg.length() - BasicProtocol.PROTOCOL_LENGHT);
    }
}
