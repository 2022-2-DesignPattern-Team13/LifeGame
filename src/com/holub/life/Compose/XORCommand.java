package com.holub.life.Compose;


import java.io.*;
import java.util.*;

public class XORCommand implements ComposeCommand{

    private static XORCommand Instance;
    private static final String name = "XOR";

    private XORCommand(){}

    public static XORCommand getInstance(){
        if(Instance==null){
            Instance=new XORCommand();

        }
        return Instance;
    }

    public String getName(){
        return name;
    }

    @Override
    public Collection execute(Collection cell1, Collection cell2) {
        return xor(cell1, cell2);
    }

    public <T> Set<T> union(Collection<T> list1, Collection<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return set;
    }

    public <T> List<T> intersection(Collection<T> list1, Collection<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

    public <T> List<T> xor(Collection<T> list1, Collection<T> list2) {
        List<T> intersect = intersection(list1,list2);
        Set<T> union=union(list1,list2);

        union.removeAll(intersect);

        return new ArrayList<T>(union);
    }
}