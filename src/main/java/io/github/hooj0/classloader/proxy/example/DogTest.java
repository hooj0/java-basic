package io.github.hooj0.classloader.proxy.example;

/**
 * 狗代理测试
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 5, 2010 1:26:40 PM
 */
public class DogTest {

	public static void main(String[] args) {
		Dog dog = new DemiWolf();

		Dog d = (Dog) DogProxyFactory.getProxy(dog);
		d.info();
		d.run();
	}
}
