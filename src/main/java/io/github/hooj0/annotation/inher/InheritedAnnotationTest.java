package io.github.hooj0.annotation.inher;

import io.github.hooj0.BasedTests;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 继承了注释测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 10:01:33
 */
@SuppressWarnings("ALL")
public class InheritedAnnotationTest extends BasedTests {

    @Test
    public void testChildClass() throws NoSuchMethodException {
	    Class<ChildClass> c = ChildClass.class;

        out("class");
        if (c.isAnnotationPresent(InheritedAnnotation.class)) { // true
            InheritedAnnotation ia = c.getAnnotation(InheritedAnnotation.class);
            out(ia.value());
        }

        out("method");
        Method m = c.getMethod("method", new Class[]{});
        if (m.isAnnotationPresent(InheritedAnnotation.class)) { // true
            InheritedAnnotation ia = m.getAnnotation(InheritedAnnotation.class);
            out(ia.value());
        }
    }

    @Test
    public void testChildImpl() throws NoSuchMethodException {
	    Class<ChildImpl> c = ChildImpl.class;

        out("class");
        if (c.isAnnotationPresent(InheritedAnnotation.class)) { // false
            InheritedAnnotation ia = c.getAnnotation(InheritedAnnotation.class);
            out(ia.value());
        }

        out("method");
        Method m = c.getMethod("method", new Class[]{});
        if (m.isAnnotationPresent(InheritedAnnotation.class)) { // false
            InheritedAnnotation ia = m.getAnnotation(InheritedAnnotation.class);
            out(ia.value());
        }
    }

    @Test
    public void testParentClass() throws NoSuchMethodException {
        Class<ParentClass> c = ParentClass.class;

        out("class");
        if (c.isAnnotationPresent(InheritedAnnotation.class)) { // true
            InheritedAnnotation ia = c.getAnnotation(InheritedAnnotation.class);
            out(ia.value()); // Inherited Annotation
        }

        out("method");
        Method m = c.getMethod("method", new Class[]{});
        if (m.isAnnotationPresent(InheritedAnnotation.class)) { // true
            InheritedAnnotation ia = m.getAnnotation(InheritedAnnotation.class);
            out(ia.value()); // Inherited Annotation
        }
    }
}
