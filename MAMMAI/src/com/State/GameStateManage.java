package com.State;

import State.MenuState;

public class GameStateManage {

    private GameState[] gameStates;
    private int currentState;
    private int previousState;


    public static final int NUM_STATES = 5;
    public static final int MenuState = 0 ;
    public static final int Bedroom = 1;
    public static final int Hall = 2;
    public static final int LivingRoom = 3;
    public static final int Yard = 4;

    public GameStateManage() {
        gameStates = new GameState[NUM_STATES];

        currentState = MenuState ;
        setState(MenuState);
    }
    public void setState(int i) {
        previousState = currentState;
        unloadState(previousState);
        currentState = i;
        if(i == MenuState) {
            gameStates[i] = new MenuState(this);
            gameStates[i].update();
        }
       if(i == Bedroom) {
            gameStates[i] = new State.Room.BedRoom(this);
            gameStates[i].update();

       }
       //        else if(i == LivingRoom) {
//            gameStates[i] = new LivingRoom(this);
//            gameStates[i].update();
//        }
//        else if(i == Yard) {
//            gameStates[i] = new yard(this);
//            gameStates[i].update();
//        }
    }

    public void unloadState(int i) {
        gameStates[i] = null;
    }

    public void update()
    {
        if(gameStates[currentState] != null) {
            gameStates[currentState].update();
        }
    }

    public void draw(java.awt.Graphics2D g)
    {
        if(gameStates[currentState] != null) {
            gameStates[currentState].draw(g);
        }
    }

    public void keyPressed(int key)
    {
        gameStates[currentState].keyPressed(key);
    }

    public void keyReleased(int key)
    {
        gameStates[currentState].keyReleased(key);
    }
}
