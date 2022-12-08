package com.holub.rule;

import com.holub.life.Cell;

public class ConditionItem extends ConditionComponent {
    @Override public boolean check(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        return true;
    }

    public boolean checkIsValid(){
        return true;
    }

    public boolean hasOneCondition(){return true;}
}
