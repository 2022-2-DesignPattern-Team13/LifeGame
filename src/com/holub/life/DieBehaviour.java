package com.holub.life;

public class DieBehaviour extends Behaviour{
    public void changeState(Cell cell){
        cell.setWillBeAlive(false);
    }
}
