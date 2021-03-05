package io.github.hooj0.classloader.classInit;

public class Test2 {
    static {
        //使用静态初始块为b变量赋值
        b = 6;
        System.out.println("execute");
    }

    //声明a变量指定初始值
    static int a = 5;
    static int b = 9;//（1）
    static int temp;

    static {
        System.out.println("execute2%%%");
        temp = 10;
    }

    static int c;

    /**
     * <b>function:</b>
     *
     * @param args
     * @author hoojo
     * @createDate Sep 27, 2010 10:34:51 PM
     */
    public static void main(String[] args) {
        System.out.println(Test2.a);
        System.out.println(Test2.b);
        System.out.println(Test2.temp);
        /**
         * code先b被静态初始块赋值，此时静态块b=6；当程序继续向下执行，在code（1）处时
         * 这行代码也属于静态初始块，所以b被再次赋值。
         * 当Test2初始化结束后，该类中的b值是9
         *
         * JVM初始化类的步骤
         * 1、假如这个类还没有被加载和连接，程序先加载并连接
         * 2、假如这类的直接父类还没有被初始化，则先初始化父类
         * 3、假如类中存在初始化语句，则系统依次运行初始化语句
         *
         * 当前程序，当执行到2步骤的时候。系统对直接父类的初始化也要遵循这3个步骤。
         * 如果该直接父类还有父类的，JVM会再次重复这3个步骤先初始化这个父类
         * 所以JVM总是先初始化java.lang.Object类。都会被初始化
         */
    }
}
