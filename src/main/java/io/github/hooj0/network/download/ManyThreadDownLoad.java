package io.github.hooj0.network.download;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
/***
 *  多线程下载
 * @author hoojo
 * @createDate Sep 18, 2010 11:13:34 PM
 * @file ManyThreadDownLoad.java
 * @package com.hoo.base.download
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class ManyThreadDownLoad extends Thread {
	//定义字节数组(取水容器)的长度
	private final int BUFFER_LENGTH = 32;
	//下载起点
	private long start;
	//下载结束点
	private long end;
	//下载资源输入流
	private InputStream is;
	//获取下载字节的输出的raf文件
	private RandomAccessFile raf;
	
	public ManyThreadDownLoad(long start, long end, InputStream is, RandomAccessFile raf) {
		System.out.println(start + "------>>" + end);
		this.start = start;
		this.end = end;
		this.is = is;
		this.raf = raf;
	}
	
	public void run() {
		try {
			//跳过和放弃此输入流中的 start 个数据字节
			long index = is.skip(start);
			System.out.println("inputStream-index:" + index);
			
			//设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作
			raf.seek(start);
			
			//定义读取输入流的缓冲数组
			byte[] bf = new byte[BUFFER_LENGTH];
			//当前线程负责下载资源的字节大小
			long contentLength = end - start;
			//定义最多读几次才能完成本线程下载
			long times = contentLength / BUFFER_LENGTH + 4;
			//实际读取的字节
			int readByte = 0;
			System.out.println(Thread.currentThread().getName());
			for (int i = 0; i < times; i++) {
				readByte = is.read(bf);
				System.out.println(times + "###" + readByte);
				//如果读取的字节数小于0，就退出
				if (readByte <= 0) {
					break;
				}
				//向文件中写内容
				raf.write(bf, 0, readByte);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (raf != null) {
					raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
