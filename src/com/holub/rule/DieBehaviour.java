package com.holub.rule;

import com.holub.life.Cell;

public class DieBehaviour extends Behaviour {
    public void changeState(Cell cell){
        cell.setWillBeAlive(false);
    }
}
