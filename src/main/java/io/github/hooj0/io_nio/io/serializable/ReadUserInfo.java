package io.github.hooj0.io_nio.io.serializable;

import io.github.hooj0.BasedTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 读取用户信息
 *
 * @author hoojo
 * @version 1.0
 * @date Dec 13, 2010 3:29:15 PM
 * 	 * @param args
 */
public class ReadUserInfo extends BasedTests {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = System.getProperty("user.dir");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "/file/info.txt"));
		UserInfo info = (UserInfo) ois.readObject();
		UserInfo info2 = (UserInfo) ois.readObject();
		User user = (User) ois.readObject();
		UserInfo info3 = (UserInfo) ois.readObject();
		out(info.getUser().equals(user));
		out(info2.getUser().equals(user));
		out(info2 == info3);
		out(info.getId() + "#" + info.getUser().getName());
		ois.close();
	}
}
