package io.github.hooj0.classloader.classLoader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * 引导测试
 *
 * @author hoojo
 * @version 1.0
 * @date Sep 28, 2010 7:01:07 PM
 */
public class BootstrapTest {

	public static void main(String[] args) {
		URL[] urls = Launcher.getBootstrapClassPath().getURLs();
		for (URL u : urls) {
			System.out.println(u.toExternalForm());
		}
	}
}
