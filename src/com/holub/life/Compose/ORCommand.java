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
    public FileInputStream execute(FileInputStream[] fileInput) throws IOException {


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
            composedCells=union(cell1,cell2);


            //합성된 객체를 파일로 변환
            FileOutputStream fos = new FileOutputStream("ORComposedfile");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(composedCells);

            FileInputStream fileoutput = new FileInputStream( "ORComposedfile" );

            return fileoutput;
        }
        catch(ClassNotFoundException e)
        {

            throw new IOException(
                    "Internal Error: Class not found on load");
        }

    }

    public <T> List<T> union(Collection<T> list1, Collection<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }
}
