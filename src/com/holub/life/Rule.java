package com.holub.life;

import java.util.ArrayList;
import java.util.List;

public class Rule extends RuleComponent{
    private ArrayList<RuleComponent> ruleComponents;

    public Rule(){
        this.ruleComponents = new ArrayList<>();
    }

    public void addRule(RuleComponent ruleComponent){ruleComponents.add(ruleComponent);}
    @Override public boolean apply(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        for(RuleComponent ruleComponent : ruleComponents){
            if(ruleComponent.apply(cell, north, south, east, west, northeast, northwest, southeast, southwest)){
                return true;
            }
        }
        return false;
    }
}
