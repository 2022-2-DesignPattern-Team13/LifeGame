package com.holub.rule;

import com.holub.life.Cell;
import com.holub.life.Resident;

public interface Command {
    public void execute(Cell cell);
}
