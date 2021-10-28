package io.github.hooj0.io_nio.io.serializable;

import java.io.*;

/**
 * 写用户信息
 *
 * @author hoojo
 * @version 1.0
 * @date Dec 13, 2010 3:19:18 PM
 */
public class WriteUserInfo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = System.getProperty("user.dir");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/file/info.txt"));
        User user = new User("jack", 23);
        UserInfo info = new UserInfo(user, 123);
        UserInfo info2 = new UserInfo(user, 456);
        oos.writeObject(info);
        oos.writeObject(info2);
        oos.writeObject(user);
        oos.writeObject(info2);
        oos.close();
    }
}

class UserInfo implements Serializable {
    private static final long serialVersionUID = 4297771569352520817L;
    private User user;
    private int id;

    public UserInfo() {
        super();
    }

    public UserInfo(User user, int id) {
        super();
        this.user = user;
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}