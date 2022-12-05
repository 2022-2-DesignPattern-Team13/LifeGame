package com.holub.rule;

import com.holub.rule.LogicalOperation;

public class LogicalAnd implements LogicalOperation {
    @Override
    public boolean operate(boolean c1, boolean c2) {
        return c1 && c2;
    }

    @Override
    public boolean operate(boolean c) {
        return c;
    }


    @Override
    public String toString() {
        return "&&";
    }
}
