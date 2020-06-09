package io.github.hooj0.classloader.instance;

/**
 * 用户
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:46:12
 */
public class User {

    private String name;
    private String sex;
    private String age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sex + ", " + this.age;
    }
}
