package com.holub.rule;

import com.holub.life.Cell;
import com.holub.rule.Compare;
import com.holub.rule.ConditionItem;

public class AliveCondition extends ConditionItem {
    private boolean targetIsAlive;
    private Compare compare;

    public AliveCondition(boolean targetIsAlive, Compare compare){
        this.targetIsAlive = targetIsAlive;
        this.compare = compare;
    }

    @Override
    public boolean check(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest) {
        return compare.compare(targetIsAlive, cell.isAlive());
    }
}
