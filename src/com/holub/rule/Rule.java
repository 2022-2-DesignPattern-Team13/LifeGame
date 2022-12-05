package com.holub.rule;

import com.holub.life.Cell;
import com.holub.rule.RuleComponent;

import java.util.ArrayList;

public class Rule extends RuleComponent {
    private ArrayList<RuleComponent> ruleComponents;
    public Rule(){
        ruleComponents = new ArrayList<>();

        // 가장 낮은 우선순위의 규칙은 그냥 죽는 것
        ruleComponents.add(new RuleItem(new Condition(new NullLogicalOperation()), new DieBehaviour()));
    }

    public void addRule(RuleComponent ruleComponent){
        ruleComponents.add(0, ruleComponent);
    }

    public void addRule(int index, RuleComponent ruleComponent){
        ruleComponents.add(index, ruleComponent);
    }

    public void removeRule(RuleComponent ruleComponent){
        ruleComponents.remove(ruleComponent);
    }
    @Override public boolean apply(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        for(RuleComponent ruleComponent : ruleComponents){
            if(ruleComponent.apply(cell, north, south, east, west, northeast, northwest, southeast, southwest)){
                return true;
            }
        }
        return false;
    }
}
