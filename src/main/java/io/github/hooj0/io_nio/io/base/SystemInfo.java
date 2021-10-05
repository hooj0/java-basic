package io.github.hooj0.io_nio.io.base;

import io.github.hooj0.BasedTests;

import java.util.*;
import java.util.Map.Entry;

/**
 * 系统信息
 *
 * @author hoojo
 * @version 1.0
 * @date Dec 12, 2010 4:34:36 PM
 */
public class SystemInfo extends BasedTests {

    public static void main(String[] args) {
        Properties pro = System.getProperties();
        Set<Entry<Object, Object>> s = pro.entrySet();
        Iterator<Entry<Object, Object>> iter = s.iterator();
        while (iter.hasNext()) {
            Entry<Object, Object> ety = iter.next();
            out(ety.getKey() + "##" + ety.getValue());
        }

        out("##########################");
        Set<Object> set = pro.keySet();
        for (Object o : set) {
            out(o + "=" + pro.getProperty(o.toString()) + "###" + pro.get(o));
        }

        out("##########################");
        Enumeration<Object> en = pro.keys();
        while (en.hasMoreElements()) {
            Object o = en.nextElement();
            out(o + "%%%" + pro.getProperty(o.toString()) + "###" + pro.get(o));
        }

        out("##########################");
        Enumeration<Object> ele = pro.elements();
        while (ele.hasMoreElements()) {
            Object o = ele.nextElement();
            out(o);
        }

        out("————————————————————————————————————");
        Collection<Object> v = pro.values();
        Iterator<Object> o = v.iterator();
        while (o.hasNext()) {
            Object value = o.next();
            out(value);
        }
    }
}
