package com.holub.life.Compose;

import com.holub.ui.ComposeWindow;

import java.io.FileInputStream;
import java.io.IOException;

public class ComposeControl {

    private ComposeCommand[] composeCommands;
    private static ComposeControl Instance;

    private ComposeControl() {
        composeCommands = new ComposeCommand[3];
        composeCommands[0] = ANDCommand.getInstance();
        composeCommands[1]=ORCommand.getInstance();
        composeCommands[2]=XORCommand.getInstance();
    }

    public static ComposeControl getInstance() {
        if (Instance == null) {
            Instance = new ComposeControl();

        }
        return Instance;
    }

    public FileInputStream doCompose(FileInputStream[] fileInput, int commandNm) throws IOException {
        return composeCommands[commandNm].execute(fileInput);
    }

    public String[] getCommands(){
        String[] commands = new String[composeCommands.length];
        for (int i=0;i<composeCommands.length;i++){
            commands[i] = composeCommands[i].getName();
        }
        return commands;
    }
}