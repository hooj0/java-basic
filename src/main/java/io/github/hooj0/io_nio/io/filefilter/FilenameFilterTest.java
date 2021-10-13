package io.github.hooj0.io_nio.io.filefilter;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterTest {

	/**
	 * <b>function:</b>

	 * @createDate Dec 12, 2010 5:42:16 PM
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File(".");
		String[] names = file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".java") || new File(name).isDirectory();
			}
		});
		for (String name : names) {
			System.out.println(name);
		}
	}
	/**
	 * FilenameFilter 接口里包含一个accept(File dir, String name)
	 * 该方法将以此对指定File的所有子目录、子文件夹进行迭代，如果方法返回true
	 * 则list方法会列出该目录或子文件夹
	 */
}
