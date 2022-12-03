package com.holub.rule;

import com.holub.life.Cell;

public class RuleComponent {
    protected Behaviour behaviour;
    public boolean apply(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        return false;
    }

    public void addRule(RuleComponent ruleComponent){}
}
