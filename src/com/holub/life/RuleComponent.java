package com.holub.life;

import java.util.ArrayList;

public class RuleComponent {
    protected Behaviour behaviour;
    public boolean apply(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        return false;
    }

    public void addRule(RuleComponent ruleComponent){}
}
