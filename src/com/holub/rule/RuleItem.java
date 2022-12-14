package com.holub.rule;

import com.holub.life.Cell;

public class RuleItem {
    private ConditionComponent conditionComponents;
    private Behaviour behaviour;

    public RuleItem(ConditionComponent conditionComponents, Behaviour behaviour){
        this.conditionComponents = conditionComponents;
        this.behaviour = behaviour;
    }
    public boolean apply(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        if(conditionComponents.check(cell, north, south, east, west, northeast, northwest, southeast, southwest)){
            behaviour.changeState(cell);
            return true;
        }
        return false;
    }
}
