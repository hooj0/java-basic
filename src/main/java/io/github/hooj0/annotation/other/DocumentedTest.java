package io.github.hooj0.annotation.other;

/**
 * 文档doc测试
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 30, 2010 5:32:29 PM
 */
@SuppressWarnings("ALL")
@DocumentedAnnotation({"E", "F"})
public class DocumentedTest {
	
	@DocumentedAnnotation({"a", "b"})
	public void method() {
		System.out.println("hi");
	}
	
	public static void main(String[] args) {
		DocumentedTest d = new DocumentedTest();
		d.method();
	}
}
