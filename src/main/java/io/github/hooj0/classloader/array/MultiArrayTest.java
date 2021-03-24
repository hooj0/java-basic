package io.github.hooj0.classloader.array;

import io.github.hooj0.BasedTests;

import java.lang.reflect.Array;

@SuppressWarnings("ALL")
public class MultiArrayTest extends BasedTests {

    /**
     * <b>function:</b>
     *
     * @param args
     * @author hoojo
     * @createDate Oct 4, 2010 5:18:12 PM
     */
    public static void main(String[] args) {
        //三维数组
        Object arr = Array.newInstance(String.class, new int[]{ 3, 4, 10 });
        Object arrObj = Array.get(arr, 2);

        Array.set(arrObj, 2, new String[]{ "Struts2", "Hibernate" });
        Object arrObj2 = Array.get(arrObj, 3);
        Array.set(arrObj2, 8, "javaEE");

        String[][][] cast = (String[][][]) arr;
        out(cast[2][3][8]);
        out(cast[2][2][0]);
        out(cast[2][2][1]);
    }
}
