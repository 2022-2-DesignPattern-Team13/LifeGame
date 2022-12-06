package com.holub.rule;

import com.holub.life.Cell;

public class ConditionComponent {
    public boolean check(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        return false;
    }
    public void addCondition(ConditionComponent conditionComponent) throws Exception{
        return;
    }
    public void removeCondition(ConditionComponent conditionComponent){
        return;
    }

    public String toString(){
        return "";
    }

    public void setOperation(LogicalOperation logicalOperation){}

    public boolean checkIsValid(){
        return false;
    }

    public boolean hasOperation(){
        return false;
    }

}
