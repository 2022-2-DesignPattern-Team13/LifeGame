package com.holub.rule;

import com.holub.life.Cell;

public class DieBehaviour implements Behaviour {
    public void changeState(Cell cell){
        cell.setWillBeAlive(false);
    }

    @Override
    public String toString() {
        return "Die";
    }
}
