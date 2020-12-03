package io.github.hooj0.generic.generictype;

/**
 * 简单集合
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 6, 2010 9:34:27 PM
 */
@SuppressWarnings("unchecked")
public class SimpleCollection<T> {
	private T[] array;
	private int index;
	
	public SimpleCollection() {
		array = (T[]) new Object[10];
	}
	
	public SimpleCollection(int length) {
		array = (T[]) new Object[length];
	}
	
	public void add(T ele) {
		array[index] = ele;
		index++;
	}
	
	public T get(int index) {
		return array[index];
	}
	
	public int length() {
		return index;
	}
	
	public static void main(String[] args) {
		SimpleCollection<String> arr = new SimpleCollection<String>();
		for (int i = 0; i < 10; i++) {
			arr.add(i + "星星");
		}
		
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr.get(i));
		}
		
		SimpleCollection<Integer> arr2 = new SimpleCollection<Integer>();
		for (int i = 0; i < 10; i++) {
			arr2.add(i);
		}
		for (int i = 0; i < arr2.length(); i++) {
			System.out.println(arr2.get(i));
		}
	}
}
