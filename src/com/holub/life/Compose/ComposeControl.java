package com.holub.life.Compose;

import com.holub.ui.ComposeWindow;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class ComposeControl {

    private ComposeCommand[] composeCommands;
    private static ComposeControl Instance;

    private ComposeControl() {
        composeCommands = new ComposeCommand[3];
        composeCommands[0] = ANDCommand.getInstance();
        composeCommands[1] = ORCommand.getInstance();
        composeCommands[2] = XORCommand.getInstance();
    }

    public static ComposeControl getInstance() {
        if (Instance == null) {
            Instance = new ComposeControl();

        }
        return Instance;
    }

    public FileInputStream doCompose(FileInputStream[] fileInput, int commandNm) throws IOException {


        Collection cell1 = new ArrayList();
        Collection cell2 = new ArrayList();
        Collection composedCells = new ArrayList();

        try {
            //fileinput 받아와서 객체로 저장
            ObjectInputStream source1 = new ObjectInputStream(fileInput[0]);
            ObjectInputStream source2 = new ObjectInputStream(fileInput[1]);
            cell1 = (Collection) (source1.readObject());
            cell2 = (Collection) (source2.readObject());

            //compose command
            composedCells = composeCommands[commandNm].execute(cell1, cell2);

            //합성된 객체를 파일로 변환
            FileOutputStream fos = new FileOutputStream("ANDComposedfile");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(composedCells);

            FileInputStream fileoutput = new FileInputStream("ANDComposedfile");

            return fileoutput;
        } catch (ClassNotFoundException e) {

            throw new IOException(
                    "Internal Error: Class not found on load");
        }
    }

    public String[] getCommands() {
        String[] commands = new String[composeCommands.length];
        for (int i = 0; i < composeCommands.length; i++) {
            commands[i] = composeCommands[i].getName();
        }
        return commands;
    }
}