package io.github.hooj0.collection.base;

import java.util.PriorityQueue;

/**
 * 优先队列测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 12, 2011 9:24:49 PM
 */
public class PriorityQueueTest {

	/**
	 * PriorityQueue保存队列元素的顺序并不是按照加入队列的顺序
	 * 而是按队列元素的大小进行重新排序，因此当调用peek方法或poll方法
	 * 来取出队列中的元素时，并不是取出最先进入队列的元素，而是取出队列中最小的元素，
	 * 先进先出FIFO的原则
	 */
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//向队列中加入元素
		pq.offer(6);
		pq.offer(-3);
		pq.offer(9);
		pq.offer(0);
		pq.add(2);
		pq.add(-1);
		pq.add(4);
		
		//输出pq队列，并没有按照元素加入的先后顺序排列 [-3, 0, 9, 6]
		System.out.println(pq);
		//访问队列的第一个元素
		System.out.println(pq.peek());
	}
}
