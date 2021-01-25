package io.github.hooj0.system;

import java.io.IOException;


public class RuntimeTest {

	/**
	 *
	 * @author hoojo
	 * @createDate Jan 14, 2011 10:52:01 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		System.out.println("cup count: " + rt.availableProcessors());
		System.out.println("空闲内存：" + rt.freeMemory());
		System.out.println("总内存：" + rt.totalMemory());
		System.out.println("最大可用内存：" + rt.maxMemory());
		
		rt.exec("notepad");
	}
}
