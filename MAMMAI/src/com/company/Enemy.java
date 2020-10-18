package com.company;

import java.awt.*;

public class Enemy {
    private int x;
    private int y;
    private int speedEnemy = 2;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(x, y, 32, 32);
    }

    public void update() {

        if (GamePanel.tracking == true) {
            if(x >= GamePanel.x){
                x -= speedEnemy ;
            }
            else if(x <= GamePanel.x){
                x+= speedEnemy ;
            }
            else  if(x == GamePanel.x){
                x = 0 ;
            }

            if(y >= GamePanel.y){
                y -= speedEnemy;

            }else if (y<= GamePanel.y){
                y += speedEnemy ;

            }  else  if(y == GamePanel.y){
                y = 0 ;
            }

        }

    }
}

