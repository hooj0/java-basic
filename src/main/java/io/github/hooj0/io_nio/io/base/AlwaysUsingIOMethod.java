package io.github.hooj0.io.base;

import java.io.File;
import java.io.IOException;

public class AlwaysUsingIOMethod {
	
	public static final void fail(Object o) {
		System.out.println(o.toString());
	}
	
	/**
	 * <b>function:</b>

	 * @createDate Dec 12, 2010 4:24:23 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		
		File file = new File(path + "\\file\\temp.txt");
		/*
		 * 访问文件名相关的方法
		 **/
		/** 返回file的文件名或路径名（最后一个目录名称） */
		fail("getName: " + file.getName());
		/** 返回file对应的路径名 */
		fail("getPath: " + file.getPath());
		/** 返回file的绝对路径 */
		fail("getAbsolutePath: " + file.getAbsolutePath());
		/** 返回file对应的绝对路径File对象 */
		fail("getAbsoluteFile: " + file.getAbsoluteFile());
		//返回file对应目录（最后一级子目录）的父目录名
		fail("getParent: " + file.getParent());
		//返回file对应目录（最后一级子目录）的父目录
		fail("getParentFile: " + file.getParentFile());
		//对file进行重命名（目录、文件），命名成功返回true、否则返回false
		fail("renameTo: " + file.renameTo(new File(path + "\\file\\temp1.txt")));
		
		/*
		 * 文件检测相关的方法
		 */
		//判断文件是否存在（目录、文件）
		fail("exists: " + file.exists());
		//是否可写
		fail("canWrite: " + file.canWrite());
		//是否可读
		fail("canRead: " + file.canRead());
		//是否是文件
		fail("isFile: " + file.isFile());
		//是否是目录
		fail("isDirectory: " + file.isDirectory());
		//是否是隐藏
		fail("isHidden: " + file.isHidden());
		//判断是相对文件路径还是绝对文件路径；window的绝对路径带盘符，unix、linux、bsd是以/开头代表绝对路径
		fail("isAbsolute: " + file.isAbsolute());
		
		/*
		 * 获取常规文件信息
		 */
		//返回文件最后修改时间
		fail("lastModifed: " + file.lastModified());
		//文件内容长度
		fail("length： " + file.length());
		
		/*
		 * 文件操作的相关方法
		 */
		//当此文件对应的文件不存在就创建一个新文件，创建成功true，否则false
		fail("createNewFile: " + file.createNewFile());
		//删除文件或目录
		fail("delete: " + file.delete());
		//在默认文件目录中创建一个临时的空文件，使用指定前缀、系统生成的随机数和给定后缀做为文件名
		fail("createTempFile: " + File.createTempFile("temmppp", ".tmp"));
		//在指定目录下创建一个临时的空文件，使用指定前缀、系统生成的随机数和给定后缀做为文件名
		fail("createTempFile: " + File.createTempFile("temmppp", ".tmp", file.getParentFile()));
		//注册一个删除钩子，当jvm退出的时候，删除file对应的目录或文件
		fail("deleteOnExit: ");
		file.deleteOnExit();
		
		/*
		 * 目录操作相关方法
		 */
		//创建一个目录，创建成功返回true，否则返回false
		fail("mkDir: " + file.mkdir());
		// 创建目录，包括中间不存在的父目录
		fail("mkdirs: " + file.mkdirs());
		//列出file对应的文件或目录，返回String数组
		fail("list: " + file.list());
		//列出file对应的文件或目录，返回File数组
		fail("listFiles: " + file.listFiles());
		//列出系统根路径
		File[] files = File.listRoots();
		for (File f : files) {
			fail("listRoots: " + f);
		}
		//文件路径和分隔符
		fail(File.pathSeparator);
		fail(File.separator);
		fail(File.pathSeparatorChar);
		fail(File.separatorChar);
	}
}
