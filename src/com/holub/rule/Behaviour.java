package com.holub.rule;

import com.holub.life.Cell;

public interface Behaviour {
    public void changeState(Cell cell);

    public String toString();
}
