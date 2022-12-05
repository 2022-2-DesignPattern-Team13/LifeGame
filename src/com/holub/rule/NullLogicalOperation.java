package com.holub.rule;

public class NullLogicalOperation implements LogicalOperation {
    @Override
    public boolean operate(boolean c1, boolean c2) {
        return true;
    }

    @Override
    public boolean operate(boolean c) {
        return c;
    }

    @Override
    public String toString() {
        return "";
    }
}
