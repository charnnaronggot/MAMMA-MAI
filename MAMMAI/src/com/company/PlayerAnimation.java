package com.company;

import java.awt.image.BufferedImage;

public class PlayerAnimation {

    private BufferedImage[] frames ;
    private int currentFrame ;

    private long startTime ;
    private long delay ;

    public PlayerAnimation(){}

    public void setFrames(BufferedImage[] image){
        frames = image ;
        if(currentFrame >= frames.length){
            currentFrame = 0 ;
        }
    }
    public void setDelay(long d){
        delay = d ;
    }

    public void update (){
        if(delay == -1)return;
        long elapsed = (System.nanoTime()- startTime) / 1000000 ;
        if(elapsed>delay){
                 currentFrame++;
                 startTime = System.nanoTime() ;
        }
        if(currentFrame == frames.length) {
            currentFrame = 0;
        }



    }
    public  BufferedImage getImage(){
        return  frames[currentFrame] ;
    }

}
