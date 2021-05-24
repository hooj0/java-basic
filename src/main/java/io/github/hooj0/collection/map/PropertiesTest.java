package io.github.hooj0.collection.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 12, 2011 10:51:35 PM
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.setProperty("username", "jack");
		props.setProperty("password", "123456");
		//将props内容保存在a.ini文件中
		props.store(new FileOutputStream("a.ini"), "coment line");
		Properties pro = new Properties();
		pro.setProperty("java", "easy");
		//将a.ini文件中的属性名 属性值追加到pro中
		pro.load(new FileInputStream("a.ini"));
		
		System.out.println(pro);
		System.out.println(props);
	}
}
