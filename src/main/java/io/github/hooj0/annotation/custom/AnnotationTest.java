package io.github.hooj0.annotation.custom;

@SuppressWarnings("ALL")
public class AnnotationTest {
	
	/*
	 * 使用自定义annotation
	 */
	@CustomAnnotation
	public void method() {
		System.out.println("this is method");
	}
	
	/*
	 * 如果不为@CustomAnnotationField的field属性赋值，编译将无法通过
	 * 所以要设置field的值
	 * 就像一个接口，你定义的方法实现它的子类一定要实现接口的方法一样
	 */
	@CustomAnnotationField(field = "testField")
	public void method2() {
		System.out.println("this is method 2");
	}
	
	/*
	 * 使用默认属性value，可以忽略value直接赋值
	 */
	@CustomAnnotationDefault("defaultValue")
	public void method3() {
		System.out.println("this is method 3");
	}
	
	/*
	 * 显示的为value赋值也可以
	 * 为SuppressWarnings的value显示赋值
	 */
	@SuppressWarnings(value = "unchecked")
	@CustomAnnotationDefault(value = "defaultValue")
	public void method4() {
		System.out.println("this is method 4");
	}
	
	/*
	 * 为自定义annotation的属性赋值
	 * 只要自定义annotation中出现的属性，都需要赋一个值
	 */
	@CustomAnnotationCustomField(name = "张三", age = 22, customField = "自定义")
	public void method5() {
		System.out.println("this is method 5");
	}
	
	/*
	 * 虽然@CustomAnnotationDefaultValue中存在自定义属性，我们没有为属性赋值
	 * 编译也可以通过，这是因为为它的自定义属性都赋了默认值
	 * 默认在不显示赋值的情况下使用默认值
	 */
	@CustomAnnotationDefaultValue
	public void method6() {
		System.out.println("this is method 6");
	}
	
	/*
	 * 隐式为value赋值，默认不提供属性名称就是value
	 */
	@CustomAnnotationDefaultValue("abc")
	public void method7() {
		System.out.println("this is method 7");
	}
	
	/*
	 * 显示为age赋值
	 */
	@CustomAnnotationDefaultValue(age = 11)
	public void method8() {
		System.out.println("this is method 8");
	}
	
	/*
	 * 多个属性时，当value没有默认值要显示的为value赋值
	 * 自定义Annotation中可以出现枚举属性、数组、常用类型都可以
	 * 如果是数组类型时，一个值的时候可以省略大括号，多个值就要带大括号
	 */
	@CustomAnnotationFieldType(ages = {22, 33}, code = CharCode.B, value = "abc")
	public void method9() {
		System.out.println("this is method 9");
	}
	
	/**
	 *
	 * @author hoojo
	 * @createDate Oct 30, 2010 2:29:39 PM
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationTest test = new AnnotationTest();
		test.method();
		/*
		 * 编译、运行无错误
		 */
		test.method2();
		test.method3();
		test.method4();
		test.method5();
		test.method6();
		test.method7();
		test.method8();
		test.method9();
	}
}
