package io.github.hooj0.generic.generictype.confine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class GenericList<T extends List<?>> {
	private T list;

	public T getList() {
		return list;
	}

	public void setList(T list) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		GenericList<ArrayList<String>> list = new GenericList<ArrayList<String>>();
		ArrayList<String> aList = new ArrayList<String>(10);
		aList.add("abc");
		list.setList(aList);
		
		GenericList<LinkedList<Integer>> linkList = new GenericList<LinkedList<Integer>>();
		ArrayList<Integer> iList = new ArrayList<Integer>();
		iList.add(111);
		//linkList.setList(iList);	
		LinkedList<Integer> lList = new LinkedList<Integer>();
		lList.add(222);
		linkList.setList(lList);
		
		LinkedList<String> lList2 = new LinkedList<String>();
		lList2.add("aaa");
		//linkList.setList(lList2);
		
		GenericList<Vector<?>> vector = new GenericList<Vector<?>>();
		Vector<Boolean> v = new Vector<Boolean>(2);
		v.add(true);
		vector.setList(v);
		
		//Hashtable没有实现List接口
		//GenericList<Hashtable> t = new GenericList<Hashtable>();
	}
}
