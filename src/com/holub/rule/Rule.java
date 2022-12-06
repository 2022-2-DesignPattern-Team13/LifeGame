package com.holub.rule;

import com.holub.life.Cell;

import java.util.ArrayList;

public class Rule{
    private ArrayList<RuleItem> rules;
    public Rule(){
        rules = new ArrayList<>();

        // 가장 낮은 우선순위의 규칙은 그냥 죽는 것
        rules.add(new RuleItem(new Condition(new NullLogicalOperation()), new DieBehaviour()));
    }

    public void addRule(RuleItem ruleItem){
        rules.add(0, ruleItem);
    }

    public void addRule(int index, RuleItem ruleItem){
        rules.add(index, ruleItem);
    }

    public void removeRule(RuleItem rule){
        rules.remove(rule);
    }
    public boolean apply(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        for(RuleItem rule : rules){
            if(rule.apply(cell, north, south, east, west, northeast, northwest, southeast, southwest)){
                return true;
            }
        }
        return false;
    }
}
