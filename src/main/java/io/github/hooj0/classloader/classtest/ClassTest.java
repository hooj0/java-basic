package io.github.hooj0.classloader.classtest;

import io.github.hooj0.BasedTests;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 类测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:25:34
 */
@SuppressWarnings("unused")
public class ClassTest extends BasedTests {

    private ClassTest() {
        out("私有方法构造器");
    }

    public ClassTest(String name) {
        out("带参方法构造器 " + name);
    }

    public void info() {
        out("执行info方法");
    }

    public void info(String args) {
        out("执行带参info方法……" + args);
    }

    @SuppressWarnings("unused")
    private static final String name = "abc";
    public int age = 10;

    class Inner {
    }

    class InnerTest {
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Class<ClassTest> clazz = ClassTest.class;
        //获取ClassTest对象的所有构造器
        Constructor[] ctr = clazz.getDeclaredConstructors();
        out("classTest的全部构造器：");
        for (Constructor c : ctr) {
            out(c);
        }
        //获取classTest的全部public构造器
        Constructor[] pubCts = clazz.getConstructors();
        out("public 构造器：");
        for (Constructor c : pubCts) {
            out(c);
        }
        //获取该Class对象的全部public方法
        Method[] method = clazz.getMethods();
        out("所有method方法：");
        for (Method m : method) {
            out(m);
        }
        //获取当前class指定的方法
        out("ClassTest 里带有参数的Info方法为：" + clazz.getMethod("info", String.class));
        //获取当前Class对象对应所有类的注释
        Annotation[] anns = clazz.getAnnotations();
        out("Anneotation注解：");
        for (Annotation a : anns) {
            out(a);
        }
        out("Class元素上的@SuppressWarnings注解为：" + clazz.getAnnotation(SuppressWarnings.class));

        Field[] field = clazz.getDeclaredFields();
        out("所有属性：");
        for (Field f : field) {
            out(f);
        }
        out("name属性：" + clazz.getField("age"));

        //获取当前对象的所有内部类
        Class<?>[] innerClass = clazz.getDeclaredClasses();
        out("classTest的匿名类：");
        for (Class c : innerClass) {
            out(c);
        }

        Class<?> inClazz = Class.forName("com.hoo.base.classtest.ClassTest$Inner");
        //通过getDeclaringClass方法访问该类对应的外部类
        out("innerClass的外部类：" + inClazz.getDeclaringClass());
        out("包名：" + clazz.getPackage());
        out("父类：" + clazz.getSuperclass());
    }
}
