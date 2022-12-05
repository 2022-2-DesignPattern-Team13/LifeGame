package com.holub.rule;


import com.holub.life.Cell;

public class NeighborCountCondition extends ConditionItem {
    int targetNeighborCount;
    Compare compare;
    public NeighborCountCondition(int targetNeighborCount, Compare compare){
        this.targetNeighborCount = targetNeighborCount;
        this.compare = compare;
    }

    public String toString(){
        return "Neighbor count condition";
    }

    @Override
    public boolean check(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest) {
        int neighbors = 0;
        if( north.	  isAlive()) ++neighbors;
        if( south.	  isAlive()) ++neighbors;
        if( east. 	  isAlive()) ++neighbors;
        if( west. 	  isAlive()) ++neighbors;
        if( northeast.isAlive()) ++neighbors;
        if( northwest.isAlive()) ++neighbors;
        if( southeast.isAlive()) ++neighbors;
        if( southwest.isAlive()) ++neighbors;

        return compare.compare(neighbors, targetNeighborCount);
    }
}
