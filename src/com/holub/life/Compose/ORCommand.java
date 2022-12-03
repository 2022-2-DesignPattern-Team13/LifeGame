package com.holub.life.Compose;


import java.io.*;
import java.util.*;

public class ORCommand implements ComposeCommand{

    private static ORCommand Instance;
    private static final String name = "OR";

    private ORCommand(){}

    public static ORCommand getInstance(){
        if(Instance==null){
            Instance=new ORCommand();

        }
        return Instance;
    }

    public String getName(){
        return name;
    }

    @Override
    public Collection execute(Collection cell1, Collection cell2) {
        return union(cell1, cell2);
    }

    public <T> List<T> union(Collection<T> list1, Collection<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }
}
