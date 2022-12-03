package com.holub.life;

public class LogicalOr implements LogicalOperation{
    @Override
    public boolean operate(boolean b1, boolean b2) {
        return b1 || b2;
    }

    @Override
    public boolean operate(boolean c) {
        return c;
    }
}
