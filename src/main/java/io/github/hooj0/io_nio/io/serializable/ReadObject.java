package io.github.hooj0.io_nio.io.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 读对象
 *
 * @author hoojo
 * @version 1.0
 * @date Dec 13, 2010 2:58:51 PM
 */
public class ReadObject {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String path = System.getProperty("user.dir");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "/file/object.txt"));
        User user = (User) ois.readObject();//反序列化
        System.out.println(user.getName());
        System.out.println(user.getAge());
        ois.close();
    }
}
