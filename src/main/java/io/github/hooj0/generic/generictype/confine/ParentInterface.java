package io.github.hooj0.generic.generictype.confine;

/**
 * 父接口
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:21:58
 */
public interface ParentInterface<T, F> {
    public void setToo(T too);

    public void setFoo(F foo);

    public T getToo();

    public F getFoo();
}
