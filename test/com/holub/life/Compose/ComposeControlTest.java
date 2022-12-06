package com.holub.life.Compose;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.List;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ComposeControlTest {
    int andCommandNm = 0;
    int orCommandNm = 1;
    int xorCommandNm = 2;

    @Test
    void doComposeAnd() throws IOException, ClassNotFoundException {
        doCompose(andCommandNm, new FileInputStream(".\\test\\test_house_and_square"));
    }

    @Test
    void doComposeOr() throws IOException, ClassNotFoundException {
        doCompose(orCommandNm, new FileInputStream(".\\test\\test_house_or_square"));
    }

    @Test
    void doComposeXor() throws IOException, ClassNotFoundException {
        doCompose(xorCommandNm, new FileInputStream(".\\test\\test_house_xor_square"));
    }

    void doCompose(int commandNm, FileInputStream expectedFileOutput) throws IOException, ClassNotFoundException {
        ComposeControl _ComposeControl = ComposeControl.getInstance();

        FileInputStream file1 = new FileInputStream(".\\test\\test_house");
        FileInputStream file2 = new FileInputStream(".\\test\\test_square");
        FileInputStream[] fileInput = new FileInputStream[]{file1, file2};

        FileInputStream actualFileOutput = _ComposeControl.doCompose(fileInput, commandNm);

        LinkedList exp = (LinkedList) (new ObjectInputStream(expectedFileOutput)).readObject();
        Set<String> expSet = new HashSet<String>(exp);
        ArrayList act = (ArrayList) (new ObjectInputStream(actualFileOutput)).readObject();
        Set<String> actSet = new HashSet<String>(act);

        assertEquals(expSet, actSet);
    }

    @Test
    void getCommands() {
        ComposeControl _ComposeControl = ComposeControl.getInstance();
        String[] expectedCommands = new String[]{"AND", "OR", "XOR"};
        String[] actualCommands = _ComposeControl.getCommands();

        assertTrue(Arrays.equals(expectedCommands, actualCommands));
    }
}