package io.github.hooj0.classloader.instance;

import java.util.Date;

/**
 * 对象工厂
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:41:23
 */
public class ObjectFactory {

    public static Object getInstance(String clazz) {
        try {
            Class<?> cls = Class.forName(clazz);
            return cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        //需要强转
        Date d = (Date) ObjectFactory.getInstance("java.util.Date");
        System.out.println(d);
    }
}
