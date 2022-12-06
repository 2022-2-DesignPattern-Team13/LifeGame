package com.holub.rule;

import com.holub.life.Cell;

public class AliveBehaviour implements Behaviour {
    @Override
    public void changeState(Cell cell) {
        cell.setWillBeAlive(true);
    }

    @Override
    public String toString() {
        return "Alive";
    }
}
