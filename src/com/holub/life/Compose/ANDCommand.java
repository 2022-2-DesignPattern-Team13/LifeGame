package com.holub.life.Compose;

import java.io.FileInputStream;

public class ANDCommand implements ComposeCommand{

    private static ANDCommand Instance;

    private ANDCommand(){}

    public static ANDCommand getInstance(){
        if(Instance==null){
            Instance=new ANDCommand();

        }
        return Instance;
    }
    @Override
    public FileInputStream execute(FileInputStream[] fileInput) {


        return fileInput[0];
    }
}


