package io.github.hooj0.collection.base;

import io.github.hooj0.BasedTests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 收集测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 4, 2011 7:56:16 PM
 */
public class CollectionTest extends BasedTests {

    public static void main(String[] args) {
        Collection<Object> coll = new ArrayList<Object>();
        //添加元素
        coll.add("张三");
        coll.add(22);//自动装箱，new Integer
        out("c集合的元素个数：" + coll.size());
        coll.remove(22);
        out("c集合的元素个数：" + coll.size());

        out("包含指定元素否：" + coll.contains("张三"));
        out("包含指定元素否：" + coll.contains("李四"));

        coll.add("王五");
        out("coll包含元素：" + coll);
        coll.add("struts");
        coll.add("Java");

        Collection<Object> c = new HashSet<Object>();
        c.add("Java");
        c.add("struts");
        //c.add("spring");
        out("coll包含c否：" + coll.contains(c));
        out("coll完全包含c否：" + coll.containsAll(c));

        //删除包含c集合的元素
        coll.removeAll(c);
        out("coll集合的元素：" + coll);
        //删除coll集合所有的元素
        coll.clear();

        out("c集合的元素：" + coll);
        //删除coll中不包含c的元素
        c.retainAll(coll);
        out("c集合的元素：" + c);
    }
}
