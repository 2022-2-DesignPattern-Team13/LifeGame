package com.holub.life.Compose;

import com.holub.ui.ComposeWindow;

import java.io.FileInputStream;

public class ComposeControl {

    private FileInputStream[] fileInput;
    private static ComposeControl Instance ;

    private ComposeControl(){
        fileInput=new FileInputStream[2];
    }

    private static ComposeControl getInstance(){
        if(Instance==null){
            Instance=new ComposeControl();

        }
        return Instance;
    }


}
