package io.github.hooj0.annotation.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 抑制警告注释
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 28, 2010 10:20:22 PM
 */
@SuppressWarnings("ALL")
public class SupressWarningsAnnotation {
	
	@SuppressWarnings({"unchecked", "unused"})
	public static void main(String[] args) {
		/*
		 * @SuppressWarnings是用来压制警告用的，可以是一个或多个（数组）
		 */
		@SuppressWarnings("unused")
		List list = new ArrayList();
		@SuppressWarnings("unused")
		String a = "abc";
	}
}
