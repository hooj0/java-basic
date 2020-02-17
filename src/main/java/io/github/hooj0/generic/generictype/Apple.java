package io.github.hooj0.generic.generictype;

import java.io.Serializable;
import java.util.List;

/**
 * 苹果
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:22:06
 */
public class Apple<T extends List & Serializable> {

    public static void main(String[] args) {
        //T是继承List的并实现Serializable的
    }
}