package io.github.hooj0.annotation.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 定义一个Annotation
 * @author hoojo
 * @createDate Oct 30, 2010 4:17:20 PM
 * @file TestAnnotation.java
 * @package com.hoo.annotation.reflection
 * @project JavaAnnotation
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
	String[] value();
	public String name();
	int[] number() default {33, 55};
}
/*
 * 1、Retention 是Annotation类型
 * 指示注释类型的注释要保留多久。
 * 如果注释类型声明中不存在 Retention 注释，
 * 则保留策略默认为 RetentionPolicy.CLASS。 
 * 只有元注释类型直接用于注释时，Target 元注释才有效。
 * 如果元注释类型用作另一种注释类型的成员，则无效。 
 * 
 * 2、RetentionPolicy 枚举类型
 * 注释保留策略。此枚举类型的常量描述保留注释的不同策略。
 * 它们与 Retention 元注释类型一起使用，以指定保留多长的注释
 * CLASS 编译器将把注释记录在类文件中，但在运行时 VM 不需要保留注释。 
 * RUNTIME 编译器将把注释记录在类文件中，在运行时 VM 将保留注释，因此可以反射性地读取。 
 * SOURCE 编译器要丢弃的注释。 
 */
