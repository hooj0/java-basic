package io.github.hooj0.classloader.field;

import java.lang.reflect.Field;

/**
 * 属性试验
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:36:20
 */
public class FieldTest {

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Class<Person> clazz = Person.class;

        // 获取Person的name属性,使用getDeclaredField可以获取各种访问控制符的熟悉
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);//设置可以访问私有属性
        nameField.set(p, "java field");

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p, 22);

        System.out.println(p);
    }
}


class Person {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person [ name: " + this.name + ", age: " + this.age + "]";
    }
}
