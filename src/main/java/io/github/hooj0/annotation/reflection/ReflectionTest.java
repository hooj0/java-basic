package io.github.hooj0.annotation.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@SuppressWarnings("ALL")
public class ReflectionTest {

    /**
     * <b>function:</b>
     *
     * @param args
     * @author hoojo
     * @createDate Oct 30, 2010 4:18:19 PM
     */
    public static void main(String[] args) throws Exception {
        Class<Target> clazz = Target.class;

        Target target = clazz.newInstance();
        //Method m = clazz.getMethod("method", null);
        Method m = clazz.getMethod("method", new Class[]{});

        //判断method方法前面是否有annotation注解
        if (m.isAnnotationPresent(TestAnnotation.class)) {
            m.invoke(target, new Object[]{});

            //有TestAnnotation注解就得到这个注解
            TestAnnotation anno = m.getAnnotation(TestAnnotation.class);
            String name = anno.name();
            int[] number = anno.number();
            String[] value = anno.value();
            System.out.println("name:" + name);

            for (int n : number) {
                System.out.println("number:" + n);
            }
            for (String v : value) {
                System.out.println("value:" + v);
            }
        }

        Annotation[] annotations = m.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a.annotationType().getName());
            Method[] methods = a.annotationType().getMethods();
            for (Method mt : methods) {
                System.out.println(mt.getName());
            }
        }
        /**
         * 可以得到Deprecated，但不能得到@SuppressWarnings
         * 是因为@SuppressWarnings的@Retention是RetentionPolicy.SOURCE不会被jvm获得，没有编译到class文件中；
         * SuppressWarnings本身是在编译期间对警告期压制作用，没有必要保存在class文件中
         * 而Deprecated就可以获得到，因为Deprecated是RetentionPolicy.RUNTIME会被编译到class文件中，jvm运行
         * 时也可以获得到注解
         */
    }
}
