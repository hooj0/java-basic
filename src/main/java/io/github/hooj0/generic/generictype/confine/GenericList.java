package io.github.hooj0.generic.generictype.confine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 通用列表
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:20:51
 */
public class GenericList<T extends List<?>> {

    private T list;

    public T getList() {
        return this.list;
    }

    public void setList(T list) {
        this.list = list;
    }

    public static void main(String[] args) {
        GenericList<ArrayList<String>> list = new GenericList<>();
        ArrayList<String> aList = new ArrayList<>(10);
        aList.add("abc");
        list.setList(aList);

        GenericList<LinkedList<Integer>> linkList = new GenericList<>();
        ArrayList<Integer> iList = new ArrayList<>();
        iList.add(111);
        //linkList.setList(iList);
        LinkedList<Integer> lList = new LinkedList<>();
        lList.add(222);
        linkList.setList(lList);

        LinkedList<String> lList2 = new LinkedList<>();
        lList2.add("aaa");
        //linkList.setList(lList2);

        GenericList<Vector<?>> vector = new GenericList<>();
        Vector<Boolean> v = new Vector<>(2);
        v.add(true);
        vector.setList(v);

        //Hashtable没有实现List接口
        //GenericList<Hashtable> t = new GenericList<Hashtable>();
    }
}
