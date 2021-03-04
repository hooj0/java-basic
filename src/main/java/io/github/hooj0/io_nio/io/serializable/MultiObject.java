package io.github.hooj0.io_nio.io.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MultiObject {

	/**
	 * 

	 * @createDate Dec 13, 2010 3:40:33 PM
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = System.getProperty("user.dir");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/file/o.txt"));
		User user = new User("jackson", 23);
		oos.writeObject(user);//将对象转换成字节序列化输出
		user.setName("tom");//修改属性
		//系统只会输出系列号，不会改变属性值
		oos.writeObject(user);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "/file/o.txt"));
		User u = (User) ois.readObject();
		User u2 = (User) ois.readObject();
		System.out.println(u == u2);
		System.out.println(u2.getName());
		oos.close();
		ois.close();
	}
}
