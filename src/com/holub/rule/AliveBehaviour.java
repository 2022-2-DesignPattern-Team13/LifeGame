package com.holub.rule;

import com.holub.life.Cell;

public class AliveBehaviour extends Behaviour {
    @Override
    public void changeState(Cell cell) {
        cell.setWillBeAlive(true);
    }
}
