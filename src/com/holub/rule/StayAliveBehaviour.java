package com.holub.rule;

import com.holub.life.Cell;
import com.holub.rule.Behaviour;

public class StayAliveBehaviour extends Behaviour {
    public void changeState(Cell cell){
        cell.setWillBeAlive(true);
    }
}
