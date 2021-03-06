package io.github.hooj0.io_nio.nio.base;

import io.github.hooj0.BasedTests;

import java.nio.CharBuffer;

/**
 * 缓冲区测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 09:17:56
 */
@SuppressWarnings("ALL")
public class BufferTest extends BasedTests {

	public static void main(String[] args) {
		//创建Buffer
		CharBuffer buffer = CharBuffer.allocate(8);
		out("capacity: " + buffer.capacity());
		out("limit: " + buffer.limit());
		out("position: " + buffer.position());
		
		//添加元素
		buffer.put("a");
		buffer.put("b");
		buffer.put("c");
		out("加入元素后的位置， position：" + buffer.position());
		buffer.flip();
		out("执行flip方法后， position：" + buffer.position());
		out("执行flip方法后， limit：" + buffer.limit());
		
		//取得第一个元素
		out("第一个元素（position=0）：" + buffer.get());
		out("获取第一个元素（position=0）：" + buffer.position());
		
		//调用clear
		out("执行clear后的，limit：" + buffer.limit());
		out("执行clear后的，position：" + buffer.position());
		out("执行clear后的，缓冲区内容没有清除：" + buffer.get(2));
		out("执行clear后的，limit：" + buffer.limit());
		out("执行clear后的，position：" + buffer.position());
	}
}
