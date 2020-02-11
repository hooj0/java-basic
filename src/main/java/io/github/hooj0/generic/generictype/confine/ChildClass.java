package io.github.hooj0.generic.generictype.confine;

/**
 * 子类
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:20:31
 */
public class ChildClass<T, F, B, A> implements ParentInterface<A, B> {

    private T t;//String
    private F f;//Boolean
    private A a;//Float
    private B b;//Integer

    @Override
    public B getFoo() {
        return this.b;
    }

    @Override
    public A getToo() {
        return this.a;
    }

    @Override
    public void setFoo(B foo) {
        System.out.println("B:" + foo.getClass());
        this.b = foo;
    }

    @Override
    public void setToo(A too) {
        System.out.println("A:" + too.getClass());
        this.a = too;
    }

    public T getT() {
        return this.t;
    }

    public void setT(T t) {
        System.out.println("t:" + t.getClass());
        this.t = t;
    }

    public F getF() {
        return this.f;
    }

    public void setF(F f) {
        System.out.println("f:" + f.getClass());
        this.f = f;
    }

    public static void main(String[] args) {
        ChildClass<String, Boolean, Integer, Float> c = new ChildClass<>();
        c.setF(true);
        Boolean b = c.getF();
        c.setT("abc");
        String t = c.getT();
        c.setFoo(2);
        Integer foo = c.getFoo();
        c.setToo(2f);
        Float too = c.getToo();
    }
}
