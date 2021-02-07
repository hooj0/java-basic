package io.github.hooj0.annotation.other;

@SuppressWarnings("ALL")
@DocumentedAnnotation({"E", "F"})
public class DocumentedTest {
	
	@DocumentedAnnotation({"a", "b"})
	public void method() {
		System.out.println("hi");
	}
	
	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 30, 2010 5:32:29 PM
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentedTest d = new DocumentedTest();
		d.method();
	}
}
