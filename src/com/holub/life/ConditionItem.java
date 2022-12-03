package com.holub.life;

public class ConditionItem extends ConditionComponent{
    @Override public boolean check(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest){
        return true;
    }
}
