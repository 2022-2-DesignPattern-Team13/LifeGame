package com.holub.life;

import java.util.ArrayList;

public class ConditionComponent {
    ArrayList<ConditionComponent> conditionComponents;
    LogicalOperation operation;
    public boolean check(Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        return operation.operate(
                conditionComponents.get(0).check(north, south, east, west, northeast, northwest, southeast, southwest),
                conditionComponents.get(1).check(north, south, east, west, northeast, northwest, southeast, southwest)
        );
    }
    public void add(ConditionComponent conditionComponent){
        if(conditionComponents.size() >= 2){
            return;
        }

        conditionComponents.add(conditionComponent);
    }
    public void remove(ConditionComponent conditionComponent){
        conditionComponents.remove(conditionComponent);
    }

    public void setOperation(LogicalOperation operation){
        this.operation = operation;
    }
}
