package com.holub.rule;

import com.holub.life.Cell;

public class RuleControl {
    Command slot;

    public RuleControl(){}

    public void setCommand(Command command){
        slot = command;
    }

    public void execute(Cell cell){
        slot.execute(cell);
    }
}
