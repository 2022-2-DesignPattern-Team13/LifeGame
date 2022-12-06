package com.holub.life.Compose;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ORCommandTest {

    @Test
    void execute() {
        ORCommand _ORCommand = ORCommand.getInstance();
        Collection cell1 = Arrays.asList(new Point[]{new Point(3, 10), new Point(3, 11), new Point(3, 12)});
        Collection cell2 = Arrays.asList(new Point[]{new Point(1, 10), new Point(2, 10), new Point(3, 10)});
        Collection composedCells = Arrays.asList(new Point[]{new Point(3, 12), new Point(3, 11), new Point(3, 10), new Point(1, 10), new Point(2, 10)});

        assertEquals(composedCells, _ORCommand.execute(cell1, cell2));
    }
}