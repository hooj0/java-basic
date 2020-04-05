package io.github.hooj0.collection.map;

import io.github.hooj0.BasedTests;

import java.util.Hashtable;

/**
 * 哈希表测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 12, 2011 9:53:41 PM
 */
public class HashtableTest extends BasedTests {

    public static void main(String[] args) {
        Hashtable<A, Object> ht = new Hashtable<>();
        ht.put(new A(60000), "Struts2");
        ht.put(new A(87563), "Java");
        ht.put(new A(1232), new B());
        out(ht);

        //只要两个对象通过equals比较返回true，Hashtable就默认为他们是相等的value
        //只要Hashtable中有一个B对象，它与任何对象通过equals比较都相等，所以为ture
        out(ht.containsValue("Test"));

        //只要2个A对象的count属性相等，它们通过equals比较返回true，且hashCode相等
        //Hashtable即认为它们是相同的key，所以为true
        out(ht.containsKey(new A(87563)));

        ht.remove(new A(1232));
        for (Object key : ht.keySet()) {
            System.out.print(key + "--->");
            out(ht.get(key));
        }
    }
}

class A {
    int count;

    public A(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o != null && o.getClass() == A.class) {
            A a = (A) o;
            if (this.count == a.count) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.count;
    }
}

class B {
    @Override
    public boolean equals(Object o) {
        return true;
    }
}