package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.io.IOException;


/**
 * 运行时测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 14, 2011 10:52:01 PM
 */
public class RuntimeTest extends BasedTests {

	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		out("cup count: " + rt.availableProcessors());
		out("空闲内存：" + rt.freeMemory());
		out("总内存：" + rt.totalMemory());
		out("最大可用内存：" + rt.maxMemory());
		
		rt.exec("notepad");
	}
}
