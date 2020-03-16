package io.github.hooj0.collection.map;

import java.util.WeakHashMap;

/**
 * 弱散列映射测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 13, 2011 10:16:46 PM
 */
public class WeakHashMapTest {

	/**
	 * 与HashMap的区别在于，HashMap的key保留对实际对象的强引用
	 * 这意味着只要该HashMap对象不被摧毁，该HashMap对象所有key所用的
	 * 对象不会被垃圾回收，HashMap也不会自动删除这些key所对应的key-value对象；
	 * 但WeakHashMap的key只保留对实际对象的弱应用，则这些key所引用的对象可能被垃圾
	 * 回收，也有可能删除这些key或key所对应的key-value键值对
	 */
	public static void main(String[] args) {
		WeakHashMap<String, String> whm = new WeakHashMap<String, String>();
		//将WeakHashMap中添加k-v键值对
		//三个key都是匿名字符串对象(没有其他作用)
		whm.put(new String("语文"), "良好");//弱引用
		whm.put(new String("数学"), "及格");
		whm.put(new String("英文"), "中等");//new String()三个对象key-value将会被垃圾回收
		//将WeakHashMap中添加一个key-value对
		//该key是系统缓存的字符串对象
		whm.put("java", new String("中等"));//强引用
		
		System.out.println(whm);
		
		//通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		//通常只能看到一个键值对
		System.out.println(whm);
	}
}
