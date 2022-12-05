package com.holub.rule;

import com.holub.life.Cell;
public class SetRuleCommand implements Command{
    private RuleComponent rule;

    public SetRuleCommand(RuleComponent rule){
        this.rule = rule;
    }

    @Override
    public void execute(Cell cell) {
        cell.setRule(rule);
    }
}
