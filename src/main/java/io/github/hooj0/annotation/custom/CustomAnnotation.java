package io.github.hooj0.annotation.custom;

/**
 * 自定义annotation
 * @author hoojo
 * @createDate Oct 30, 2010 2:29:09 PM
 * @file CustomAnnotation.java
 * @package com.hoo.annotation.custom
 * @project JavaAnnotation
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public @interface CustomAnnotation {

}
/*
 * 自定义annotation类型，只需用在接口关键字前加一个@符号即可
 * annotation类型默认隐式实现了java.lang.annotation.Annotation接口
 * 不能再继承或实现接口
 */