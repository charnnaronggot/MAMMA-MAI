package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int x;
    private int y;
    private int speedX = 0;
    private int speedY = 0;
    private int speed = 3;


    public Player(int x, int y) {

        this.x = x;
        this.y = y;


    }

    public void update() {
        x += speedX;
        y += speedY;
        if (x <= 0 || x > Main.WIDTH) {
            x = 0;
        }
        if (y <= 0 || x > Main.HEIGHT) {
            y = 0;
        }
        if (x > 500) {
            x = 500;
        }
        if (y > 420) {
            y = 420;
        }

//            if(x<0 || x>= Main.WIDTH){
//                speedX = 0 ;
//
//
//            }else if (y < 0 || y >= Main.HEIGHT )
//                speedY = 0 ;
//
    }

    //Draw the player ;
    public void draw(Graphics2D g2d) {

        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, 32, 32);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            speedX = -speed;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            speedX = speed;
        }
        if (keyCode == KeyEvent.VK_UP) {
            speedY = -speed;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            speedY = speed;
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            GamePanel.tracking = true;
            GamePanel.x = x ;
            GamePanel.y = y ;
        }
        if(GamePanel.y >= 100 && GamePanel.y <= 200 && GamePanel.x == 500  ){

        }

    }

    public void keyReleased(KeyEvent e) {


        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            speedX = 0;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            speedX = 0;
        }
        if (keyCode == KeyEvent.VK_UP) {
            speedY = 0;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            speedY = 0;
        }


    }


}

