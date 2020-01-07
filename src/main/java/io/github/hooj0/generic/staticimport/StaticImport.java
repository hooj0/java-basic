package io.github.hooj0.generic.staticimport;


//静态导入TestUtils,.*是所有
import static io.github.hooj0.generic.source.TestUtils.*;

/**
 * 静态导入
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 16, 2010 3:07:56 PM
 */
public class StaticImport {

	public static void main(String[] args) {
		System.out.println(NAME = "bbz");
		System.out.println(getName());
	}
}
