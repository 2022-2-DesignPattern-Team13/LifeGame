package com.holub.rule;

import com.holub.life.Cell;
import com.holub.life.Resident;

public class AddRuleCommand implements Command{
    private Rule rule;

    public AddRuleCommand(Rule rule){
        this.rule = rule;
    }

    @Override
    public void execute(Cell cell) {
        cell.setRule(rule);
    }
}
