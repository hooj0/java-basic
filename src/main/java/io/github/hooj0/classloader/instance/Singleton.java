package io.github.hooj0.classloader.instance;

/**
 * 单例
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 4, 2010 4:16:07 PM
 */
public class Singleton {

    private static Singleton s;

    //私有无参构造，外部类不能实例化该类
    private Singleton() {
        System.out.println("被创建……");
    }

    public static Singleton getInstance() {
        if (s == null) {
            synchronized (Singleton.class) {
                if (s == null) {
                    s = new Singleton();
                }
            }
        }

        return s;
    }
}
