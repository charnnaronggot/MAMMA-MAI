package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Create for manage keyboard event ;
public class KeyPress extends KeyAdapter {

    Player player;
    private KeyEvent e;

    public KeyPress(Player player) {
        this.player = player;
    }


    @Override
    public void keyPressed (KeyEvent e){
        player.keyPressed(e);

    }


    @Override
    public void keyReleased(KeyEvent e) {

        player.keyReleased(e);
    }




}
//    public void keyReleased(KeyEvent key) {
//        int keyCode = key.getKeyCode();
//        if (keyCode == KeyEvent.VK_LEFT) {
//            player.setLeaf(false);
//        }
//        if (keyCode == KeyEvent.VK_RIGHT) {
//            player.setRight(false);
//        }
//        if (keyCode == KeyEvent.VK_UP) {
//            player.setUp(false);
//        }
//        if (keyCode == KeyEvent.VK_DOWN) {
//            player.setDown(false);
//        }
//}
