package com.holub.rule;

public class CompareEqualOrMoreThan implements Compare {
    @Override
    public boolean compare(int a, int b) {
        return a<=b;
    }

    @Override
    public boolean compare(boolean a, boolean b) {
        return a==b;
    }

    public String toString(){
        return "equal or more than";
    }
}
