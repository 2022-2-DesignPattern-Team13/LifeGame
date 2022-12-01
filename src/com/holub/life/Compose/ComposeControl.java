package com.holub.life.Compose;

import com.holub.ui.ComposeWindow;

import java.io.FileInputStream;

public class ComposeControl {

    private ComposeCommand[] composeCommands;
    private static ComposeControl Instance;

    private ComposeControl() {
        composeCommands = new ComposeCommand[1];
        composeCommands[0] = ANDCommand.getInstance();
    }

    public static ComposeControl getInstance() {
        if (Instance == null) {
            Instance = new ComposeControl();

        }
        return Instance;
    }

    public FileInputStream doCompose(FileInputStream[] fileInput, int commandNm) {
        return composeCommands[commandNm].execute(fileInput);
    }
}