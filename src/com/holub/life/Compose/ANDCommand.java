package com.holub.life.Compose;

import java.io.*;
import java.util.*;

public class ANDCommand implements ComposeCommand{

    private static ANDCommand Instance;
    private static final String name = "AND";

    private ANDCommand(){}

    public static ANDCommand getInstance(){
        if(Instance==null){
            Instance=new ANDCommand();

        }
        return Instance;
    }

    public String getName(){
        return name;
    }

    @Override
    public Collection execute(Collection cell1, Collection cell2) {
        return intersection(cell1, cell2);
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
}


