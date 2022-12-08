package com.holub.rule;

import com.holub.life.Cell;
import java.util.ArrayList;

public class Condition extends ConditionComponent {
    private ArrayList<ConditionComponent> conditionComponents;
    private LogicalOperation operation;
    public Condition(LogicalOperation logicalOperation){
        conditionComponents = new ArrayList<>();
        this.operation = logicalOperation;
    }

    public boolean checkIsValid(){
        if((operation == null || operation instanceof NullLogicalOperation) && conditionComponents.size() == 2)
            return false;

        if(conditionComponents.size() > 2)
            return false;

        if(!(operation instanceof NullLogicalOperation || operation == null) && conditionComponents.size() == 1)
            return false;

        for(ConditionComponent conditionComponent : conditionComponents){
            if(!conditionComponent.checkIsValid())
                return false;
        }
        return true;
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

    public boolean hasOperation(){return operation !=null && !(operation instanceof NullLogicalOperation);}

    public boolean hasOneCondition(){return conditionComponents.size()==1;}
    public String toString(){
        if(conditionComponents.size() == 0)
            return "";
        if(conditionComponents.size() == 1){
            return conditionComponents.get(0).toString();
        }
        return "("+conditionComponents.get(1).toString()+" "+operation.toString()+" "+conditionComponents.get(0).toString()+")";

    }
}
