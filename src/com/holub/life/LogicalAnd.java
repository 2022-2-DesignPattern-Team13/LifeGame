package com.holub.life;

public class LogicalAnd implements LogicalOperation{
    @Override
    public boolean operate(boolean c1, boolean c2) {
        return c1 && c2;
    }

    @Override
    public boolean operate(boolean c) {
        return c;
    }
}
