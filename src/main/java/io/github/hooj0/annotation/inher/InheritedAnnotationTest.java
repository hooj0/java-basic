package io.github.hooj0.annotation.inher;

import org.junit.Test;

import java.lang.reflect.Method;

@SuppressWarnings("ALL")
public class InheritedAnnotationTest {

    @Test
    public void testChildClass() throws NoSuchMethodException {
	    Class<ChildClass> c = ChildClass.class;

        System.out.println("class");
        if (c.isAnnotationPresent(InheritedAnnotation.class)) { // true
            InheritedAnnotation ia = c.getAnnotation(InheritedAnnotation.class);
            System.out.println(ia.value());
        }

        System.out.println("method");
        Method m = c.getMethod("method", new Class[]{});
        if (m.isAnnotationPresent(InheritedAnnotation.class)) { // true
            InheritedAnnotation ia = m.getAnnotation(InheritedAnnotation.class);
            System.out.println(ia.value());
        }
    }

    @Test
    public void testChildImpl() throws NoSuchMethodException {
	    Class<ChildImpl> c = ChildImpl.class;

        System.out.println("class");
        if (c.isAnnotationPresent(InheritedAnnotation.class)) { // false
            InheritedAnnotation ia = c.getAnnotation(InheritedAnnotation.class);
            System.out.println(ia.value());
        }

        System.out.println("method");
        Method m = c.getMethod("method", new Class[]{});
        if (m.isAnnotationPresent(InheritedAnnotation.class)) { // false
            InheritedAnnotation ia = m.getAnnotation(InheritedAnnotation.class);
            System.out.println(ia.value());
        }
    }

    @Test
    public void testParentClass() throws NoSuchMethodException {
        Class<ParentClass> c = ParentClass.class;

        System.out.println("class");
        if (c.isAnnotationPresent(InheritedAnnotation.class)) { // true
            InheritedAnnotation ia = c.getAnnotation(InheritedAnnotation.class);
            System.out.println(ia.value()); // Inherited Annotation
        }

        System.out.println("method");
        Method m = c.getMethod("method", new Class[]{});
        if (m.isAnnotationPresent(InheritedAnnotation.class)) { // true
            InheritedAnnotation ia = m.getAnnotation(InheritedAnnotation.class);
            System.out.println(ia.value()); // Inherited Annotation
        }
    }
}
