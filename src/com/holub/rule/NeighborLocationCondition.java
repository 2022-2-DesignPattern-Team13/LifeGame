package com.holub.rule;

import com.holub.life.Cell;

public class NeighborLocationCondition extends ConditionItem {

    private String location;
    private boolean isLocationAlive;
    public NeighborLocationCondition(String location, boolean isLocationAlive){
        this.location = location;
        this.isLocationAlive = isLocationAlive;
    }

    @Override
    public boolean check(Cell cell, Cell north, Cell south, Cell east, Cell west, Cell northeast, Cell northwest, Cell southeast, Cell southwest) {
        if(location.equals("north")){
            return isLocationAlive == north.isAlive();
        }else if(location.equals("south")){
            return isLocationAlive == south.isAlive();
        }else if(location.equals("east")){
            return isLocationAlive == east.isAlive();
        }else if(location.equals("west")){
            return isLocationAlive == west.isAlive();
        }else if(location.equals("northeast")){
            return isLocationAlive == northeast.isAlive();
        }else if(location.equals("southeast")){
            return isLocationAlive == southeast.isAlive();
        }else if(location.equals("southwest")){
            return isLocationAlive == southeast.isAlive();
        }
        return false;
    }
}
