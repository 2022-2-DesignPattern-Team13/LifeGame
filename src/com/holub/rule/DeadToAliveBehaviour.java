package com.holub.rule;

import com.holub.life.Cell;

public class DeadToAliveBehaviour extends Behaviour {
    public void changeState(Cell cell){
        cell.setWillBeAlive(true);
    }
}
