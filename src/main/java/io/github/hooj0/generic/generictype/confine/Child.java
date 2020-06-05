package io.github.hooj0.generic.generictype.confine;

/**
 * 孩子
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:20:15
 */
public class Child<F, T, H> extends Parent<T, F> {

    private H hoo;

    public H getHoo() {
        return this.hoo;
    }

    public void setHoo(H hoo) {
        this.hoo = hoo;
    }

    public static void main(String[] args) {
        Child<String, Boolean, Integer> c = new Child<>();
        Integer hoo = c.getHoo();
        String foo = c.getFoo();
        Boolean too = c.getToo();
    }
}
