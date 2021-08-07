package io.github.hooj0.network.socket.m2mChat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *  扩展HashMap,可以通过value找到对应的key
 * 并且value不能重复，通过value删除对应的key
 * @author hoojo
 * @createDate Sep 23, 2010 10:59:50 AM
 * @file BasicMap.java
 * @package com.hoo.base.socket.m2mChat
 * @project JavaNetBase
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 * @param <K>
 * @param <V>
 */
public class BasicMap<K, V> extends HashMap<K, V> {
	private static final long serialVersionUID = 534956123892560795L;

	/**
	 * 根据value，删除map中的信息
	 * @author hoojo
	 * @createDate Sep 23, 2010 11:02:46 AM
	 * @param value 值
	 */
	public void remvoeByVal(V value) {
		for (K key : this.keySet()) {
			if (this.get(key) == value || this.get(key).equals(value)) {
				this.remove(key);
				break;
			}
		}
	}
	
	/**
	 * 获取所有value的集合
	 * @author hoojo
	 * @createDate Sep 23, 2010 11:03:26 AM
	 * @return 得到所有value集合
	 */
	public Set<V> valueSet() {
		Set<V> resultSet = new HashSet<V>();
		for (K key : this.keySet()) {
			//将key对应的value添加到resultSet中
			resultSet.add(this.get(key));
		}
		return resultSet;
	}
	
	/**
	 * 根据value查找key
	 * @author hoojo
	 * @createDate Sep 23, 2010 11:03:56 AM
	 * @param value 值
	 * @return Key
	 */
	public K getKeyByVal(V value) {
		K k = null;
		for (K key : this.keySet()) {
			if (this.get(key).equals(value)) {
				k = key;
				break;
			}
		}
		return k;
	}
	
	/**
	 * override
	 * @see HashMap#put(Object, Object)
	 *  重写HashMap的put方法
	 * @author hoojo
	 * @createDate Sep 23, 2010 11:04:27 AM
	 */
	public V put(K key, V value) {
		for (V v : this.valueSet()) {
			//如果传入的value，和已经存在的value相同
			//则抛出一个RuntimeException
			if (v.equals(value) && v.hashCode() == value.hashCode()) {
				throw new RuntimeException("value不能重复值！");
			}
		}
		return super.put(key, value);
	}
}
