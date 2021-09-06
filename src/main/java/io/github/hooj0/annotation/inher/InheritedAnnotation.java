package io.github.hooj0.annotation.inher;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * 使用@Inherited将会使使用当前注解的类的子类也会继承注解
 * 并且当前注解只能使用在类上面才有效果
 */
@SuppressWarnings("ALL")
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedAnnotation {
	String value() default "Inherited Annotation";
}
