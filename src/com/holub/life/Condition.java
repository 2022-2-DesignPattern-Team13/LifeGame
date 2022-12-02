package com.holub.life;

import java.util.ArrayList;


public class Condition extends ConditionComponent{


    public Condition(LogicalOperation logicalOperation){
        conditionComponents = new ArrayList<>();
        this.operation = logicalOperation;
    }

    public boolean check(Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        return false;
    }

    @Override
    public void add(ConditionComponent conditionComponent) {
        if(conditionComponents.size() == 2){
            return;
        }
        conditionComponents.add(conditionComponent);
    }

    @Override
    public void remove(ConditionComponent conditionComponent){
        conditionComponents.remove(conditionComponent);
    }
}
