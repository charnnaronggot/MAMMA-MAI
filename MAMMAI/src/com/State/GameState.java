package com.State;

import com.State.GameStateManage;

public abstract class GameState {
    protected GameStateManage gsm;

    public abstract void init();
    public abstract void update();
    public abstract void draw(java.awt.Graphics2D g);
    public abstract void keyPressed(int key);
    public abstract void keyReleased(int key);

}
