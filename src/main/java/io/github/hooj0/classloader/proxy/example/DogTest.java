package io.github.hooj0.classloader.proxy.example;

public class DogTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 5, 2010 1:26:40 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog = new DemiWolf();
		Dog d = (Dog) DogProxyFactory.getProxy(dog);
		d.info();
		d.run();
	}
}
