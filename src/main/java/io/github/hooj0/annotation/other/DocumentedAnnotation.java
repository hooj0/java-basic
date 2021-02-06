package io.github.hooj0.annotation.other;

import java.lang.annotation.Documented;

/*
 *使用 @Documented注解，可以在生产doc文档的时候将当前文件中的注解也
 *写入到doc文档中
 */
@SuppressWarnings("ALL")
@Documented
public @interface DocumentedAnnotation {
	String[] value();
}
