package com.holub.rule;

public class CompareEqual implements Compare {
    @Override
    public boolean compare(int a, int b) {
        return a == b;
    }

    @Override
    public boolean compare(boolean a, boolean b) {
        return a==b;
    }
}
