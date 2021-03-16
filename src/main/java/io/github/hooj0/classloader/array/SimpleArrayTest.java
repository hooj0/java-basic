package io.github.hooj0.classloader.array;

import io.github.hooj0.BasedTests;

import java.lang.reflect.Array;

@SuppressWarnings("ALL")
public class SimpleArrayTest extends BasedTests {

    public static void main(String[] args) {
        Object arr = Array.newInstance(String.class, 10);
        Array.set(arr, 5, "struts");
        Array.set(arr, 6, "hibernate");
        Array.set(arr, 7, "spring");

        Object a = Array.get(arr, 5);
        Object b = Array.get(arr, 6);
        Object c = Array.get(arr, 7);
        out(a + "---" + b + "---" + c);

        String[] strAry = (String[]) arr;
        out(strAry[5]);
        out(strAry[6]);
        out(strAry[7]);
    }
}
