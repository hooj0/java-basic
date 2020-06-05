package io.github.hooj0.generic.generictype.confine;

/**
 * 父
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:21:42
 */
public class Parent<T, F> {

    private T too;
    private F foo;

    public T getToo() {
        return too;
    }

    public void setToo(T too) {
        this.too = too;
    }

    public F getFoo() {
        return foo;
    }

    public void setFoo(F foo) {
        this.foo = foo;
    }
}
