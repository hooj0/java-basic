package io.github.hooj0.classloader.classLoader;

import java.net.URL;

import sun.misc.Launcher;

public class BootstrapTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Sep 28, 2010 7:01:07 PM
	 * @param args
	 */
	public static void main(String[] args) {
		URL[] urls = Launcher.getBootstrapClassPath().getURLs();
		for (URL u : urls) {
			System.out.println(u.toExternalForm());
		}
	}
}
