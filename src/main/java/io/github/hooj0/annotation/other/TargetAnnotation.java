package io.github.hooj0.annotation.other;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
 * 只能放在类、接口、枚举上
 */
@SuppressWarnings("ALL")
@Target(ElementType.TYPE)
public @interface TargetAnnotation {
	
}
/*
@Target的ElementType设置不同的值，可以放置在不同的地方
ANNOTATION_TYPE 
	注释类型声明 
CONSTRUCTOR 
	构造方法声明 
FIELD 
	字段声明（包括枚举常量） 
LOCAL_VARIABLE 
	局部变量声明 
METHOD 
	方法声明 
PACKAGE 
	包声明 
PARAMETER 
	参数声明 
TYPE 
	类、接口（包括注释类型）或枚举声明 
*/