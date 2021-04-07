package io.github.hooj0.io.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WriteObject {

	/**
	 * <b>function:</b>

	 * @createDate Dec 13, 2010 2:51:33 PM
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path = System.getProperty("user.dir");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/file/object.txt"));
		User user = new User("tom", 33);
		oos.writeObject(user);//序列化java对象
		oos.close();
	}
	
	/**
	 * 序列化java对象，在远程调用、分布式开发中常用的方法
	 * 如EJB、RMI
	 */
}

class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
