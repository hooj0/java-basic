package io.github.hooj0.io_nio.io.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadUserInfo {

	/**
	 * <b>function:</b>

	 * @createDate Dec 13, 2010 3:29:15 PM
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = System.getProperty("user.dir");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "/file/info.txt"));
		UserInfo info = (UserInfo) ois.readObject();
		UserInfo info2 = (UserInfo) ois.readObject();
		User user = (User) ois.readObject();
		UserInfo info3 = (UserInfo) ois.readObject();
		System.out.println(info.getUser().equals(user));
		System.out.println(info2.getUser().equals(user));
		System.out.println(info2 == info3);
		System.out.println(info.getId() + "#" + info.getUser().getName());
		ois.close();
	}
}
