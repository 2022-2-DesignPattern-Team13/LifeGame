package com.holub.life;

public class DeadToAliveBehaviour extends Behaviour{
    public void changeState(Cell cell){
        cell.setWillBeAlive(true);
    }
}
