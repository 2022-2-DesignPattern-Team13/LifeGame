package com.holub.rule;

import com.holub.life.Cell;
import com.holub.rule.ConditionComponent;
import com.holub.rule.LogicalOperation;

import java.util.ArrayList;

public class Condition extends ConditionComponent {
    private ArrayList<ConditionComponent> conditionComponents;
    private LogicalOperation operation;
    public Condition(LogicalOperation logicalOperation){
        conditionComponents = new ArrayList<>();
        this.operation = logicalOperation;
    }

    public boolean check(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        if(conditionComponents.size()==2){
            return operation.operate(
                    conditionComponents.get(0).check(cell, north, south, east, west, northeast, northwest, southeast, southwest),
                    conditionComponents.get(1).check(cell, north, south, east, west, northeast, northwest, southeast, southwest)
            );
        }
        if(conditionComponents.size() == 1){
            return operation.operate(conditionComponents.get(0).check(cell, north, south, east, west, northeast, northwest, southeast, southwest));
        }

        return true;
    }

    public void addCondition(ConditionComponent conditionComponent) throws Exception{
        if(conditionComponents.size() == 2){
            throw new Exception("can't add more than 2 conditions in the parentheses");
        }
        conditionComponents.add(conditionComponent);
    }

    public void removeCondition(ConditionComponent conditionComponent){
        conditionComponents.remove(conditionComponent);
    }

    public void setOperation(LogicalOperation operation){
        this.operation = operation;
    }
}
