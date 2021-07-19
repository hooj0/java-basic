package io.github.hooj0.network.download;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

/***
 * <b>function:</b> 多线程下载
 * @author hoojo
 * @createDate Sep 23, 2010 10:50:18 AM
 * @file DownLoadTest.java
 * @package com.hoo.base.download
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DownLoadTest {
	/**
	 * <b>function:</b>获得指定网络资源的长度、大小
	 * @author hoojo
	 * @createDate Sep 23, 2010 10:50:57 AM
	 * @param url URLConnection
	 * @return long 长度
	 * @throws Exception
	 */
	public static long getFileLength(URL url) throws Exception {
		long length = 0;
		//通过url打开一个连接
		URLConnection con = url.openConnection();
		//通过链接获取下载资源的长度
		long size = con.getContentLength();
		length = size;
		return length;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int DOWN_THREAD_NUM = 4;
		final String OUT_FILE_NAME = "FILE.jpg";
		
		InputStream[] isAry = new InputStream[DOWN_THREAD_NUM];
		RandomAccessFile[] rafAry = new RandomAccessFile[DOWN_THREAD_NUM];
		
		try {
			//创建一个URL对象
			URL url = new URL("http://localhost:8080/API/ext2/examples/resizable/sara.jpg");
			//URL url = new URL("http://localhost:8080/FormComponent/multiCombo/Ext.form.MultiComboBox.js");
			//用当前url对象打开一个输入流
			isAry[0] = url.openStream();
			long fileLength = getFileLength(url);
			System.out.println("下载资源长度：" + fileLength);
			
			
			/*RandomAccessFile 参数二 mode详解
			 值  	含意
			 
			"r" 	以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。  
			"rw" 	打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。  
			"rws" 	打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到基础存储设备。  
			"rwd"   打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到基础存储设备。*/ 

			//以输出的文件名创建一个RandomAccessFile
			rafAry[0] = new RandomAccessFile(OUT_FILE_NAME, "rw");
			//创建一个大小和下载文件一样大的空文件
			for (int i = 0; i < fileLength; i++) {
				rafAry[0].write(0);
			}
			
			//每个线程应该下载的字节数
			long num = fileLength / DOWN_THREAD_NUM;
			long modeNum = fileLength % DOWN_THREAD_NUM;
			for (int i = 0; i < DOWN_THREAD_NUM; i++) {
				//为每个线程打开一个输入流，RandomAccessFile
				//让每个线程负责下载一个不同部分的内容
				if (i != 0) {
					//用url打开多个输入流
					isAry[i] = url.openStream();
					//指定当前线程的输出的RandomAccessFile对象
					rafAry[i] = new RandomAccessFile(OUT_FILE_NAME, "rw");
				}
				//启动多个线程下载
				if (i == DOWN_THREAD_NUM - 1) {
					//最后一个线程要负责剩余的部分+modeNum,并启动线程start
					new ManyThreadDownLoad(i * num, (i + 1) * num + modeNum, isAry[i], rafAry[i]).start();
				} else {
					new ManyThreadDownLoad(i * num, (i + 1) * num, isAry[i], rafAry[i]).start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
