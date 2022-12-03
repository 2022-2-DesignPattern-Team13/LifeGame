package com.holub.life;

public class StayAliveBehaviour extends Behaviour{
    public void changeState(Cell cell){
        cell.setWillBeAlive(true);
    }
}
