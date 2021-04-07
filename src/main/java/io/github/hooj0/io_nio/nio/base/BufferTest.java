package io.github.hooj0.nio.base;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		//创建Buffer
		CharBuffer buffer = CharBuffer.allocate(8);
		System.out.println("capacity: " + buffer.capacity());
		System.out.println("limit: " + buffer.limit());
		System.out.println("position: " + buffer.position());
		
		//添加元素
		buffer.put("a");
		buffer.put("b");
		buffer.put("c");
		System.out.println("加入元素后的位置， position：" + buffer.position());
		buffer.flip();
		System.out.println("执行flip方法后， position：" + buffer.position());
		System.out.println("执行flip方法后， limit：" + buffer.limit());
		
		//取得第一个元素
		System.out.println("第一个元素（position=0）：" + buffer.get());
		System.out.println("获取第一个元素（position=0）：" + buffer.position());
		
		//调用clear
		System.out.println("执行clear后的，limit：" + buffer.limit());
		System.out.println("执行clear后的，position：" + buffer.position());
		System.out.println("执行clear后的，缓冲区内容没有清除：" + buffer.get(2));
		System.out.println("执行clear后的，limit：" + buffer.limit());
		System.out.println("执行clear后的，position：" + buffer.position());
	}
}
