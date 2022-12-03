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
    public FileInputStream execute(FileInputStream[] fileInput) throws IOException{


        Collection cell1=new ArrayList();
        Collection cell2=new ArrayList();
        Collection composedCells= new ArrayList();

        try
        {
            //fileinput 받아와서 객체로 저장
            ObjectInputStream source1 = new ObjectInputStream( fileInput[0] );
            ObjectInputStream source2 = new ObjectInputStream( fileInput[1] );
            cell1 = (Collection)( source1.readObject() );
            cell2 = (Collection)( source2.readObject() );

            //AND 합성
            composedCells=intersection(cell1,cell2);


            //합성된 객체를 파일로 변환
            FileOutputStream fos = new FileOutputStream("ANDComposedfile");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(composedCells);

            FileInputStream fileoutput = new FileInputStream( "ANDComposedfile" );

            return fileoutput;
        }
        catch(ClassNotFoundException e)
        {

            throw new IOException(
                    "Internal Error: Class not found on load");
        }

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


