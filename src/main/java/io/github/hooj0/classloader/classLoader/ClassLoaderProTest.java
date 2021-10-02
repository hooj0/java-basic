package io.github.hooj0.classloader.classLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderProTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Sep 28, 2010 7:09:37 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//获取系统类加载器 
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统加载器：" + systemLoader);
		
		/**
		 * 获取系统类加载器的加载路径——通常由ClaaaPath环境变量直到；
		 * 如果操作系统没有指定ClassPath环境变量，默认以当前路径作为系统类
		 * 加载器的价值路径
		 */
		Enumeration<URL> eml = systemLoader.getResources("");
		while (eml.hasMoreElements()) {
			System.out.println(eml.nextElement());
		}
		//获得系统类加载器的父类加载器——得到扩展类加载器
		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("扩展类加载器：" + extensionLoader);
		System.out.println("扩展类加载器的加载路径:" + System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器parent：" + extensionLoader.getParent());
		/**
		 * 类加载器的Class大概要经过8个步骤：
		 * 1、检测此Class是否载入过（即在缓存中是否有此Class），如果有则直接进入8步
		 * 		否则执行第二步
		 * 2、如果父类加载器不存在（如果父类没有加载器，则要么parent一定是根加载器，要么本身就是根加载器）
		 * 		则跳到第4部，如果父类加载器存在，则接着运行第3部
		 * 3、请求父类加载器载入目录类，如果成功载入则跳入第8部，不成功跳到第7部
		 * 4、请求使用根加载器载入目录类，如果成功到8步，不成功第7步
		 * 5、寻找Class文件（从与此ClassLoader相关的类路径中寻找）。如果找到则执行第6步，如果找不到跳到7步
		 * 6、从文件中载入Class，成功进入8步
		 * 7、抛出ClassNotFoundException
		 * 8、返回Class
		 * 其中5、6运行重写ClassLoader的findClass方法来实现自己的载入策略
		 * 甚至重写loadClass方法，定义自己的载入方式
		 */
	}
}
