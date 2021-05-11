package io.github.hooj0.classloader.instance;

import java.lang.reflect.Constructor;

import javax.swing.JFrame;

public class CreateJFrame {

	/**
	 *
	 * @author hoojo
	 * @createDate Oct 4, 2010 4:02:52 PM
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		//获取jframe的class对象
		Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
		//获取jframe中一个带字符串参数的构造参数
		Constructor<?> c = jframeClazz.getConstructor(String.class);
		//用newInstance创建Constructor对象
		JFrame o = (JFrame) c.newInstance("测试窗口");
		o.setVisible(true);
		System.out.println(o);
	}
}
