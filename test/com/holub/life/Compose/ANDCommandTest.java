package com.holub.life.Compose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

class ANDCommandTest {

    @Test
    void execute() {
        ANDCommand _ANDCommand = ANDCommand.getInstance();
        Collection cell1 = Arrays.asList(new Point[]{new Point(3, 10), new Point(3, 11), new Point(3, 12)});
        Collection cell2 = Arrays.asList(new Point[]{new Point(1, 10), new Point(2, 10), new Point(3, 10)});
        Collection composedCells = Arrays.asList(new Point[]{new Point(3, 10)});

        assertEquals(composedCells, _ANDCommand.execute(cell1, cell2));
    }
}