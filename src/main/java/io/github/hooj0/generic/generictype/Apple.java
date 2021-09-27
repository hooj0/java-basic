package io.github.hooj0.generic.generictype;

import java.io.Serializable;
import java.util.List;

public class Apple<T extends List & Serializable> {
	public static void main(String[] args) {
		//T是继承List的并实现Serializable的
	}
}