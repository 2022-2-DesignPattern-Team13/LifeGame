package com.holub.life;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private ArrayList<ConditionComponent> conditionComponents;
    private Behaviour behaviour;

    public Rule(){
        conditionComponents = new ArrayList<>();
        behaviour = null;
    }

    public Rule(ArrayList<ConditionComponent> conditionComponents, Behaviour behaviour){
        this.conditionComponents = conditionComponents;
        this.behaviour = behaviour;
    }

    public void addCondition(Condition condition){
        conditionComponents.add(condition);
    }

    public void deleteCondition(Condition condition){
        conditionComponents.remove(condition);
    }

    private boolean check(Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        for(ConditionComponent conditionComponent : conditionComponents){
            if(!conditionComponent.check(north, south, east, west, northeast, northwest, southeast, southwest))
                return false;
        }
        return true;
    }


    public void apply(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        if(check(north, south, east, west, northeast, northwest, southeast, southwest)){
            behaviour.changeState(cell);
        }
    }
}
