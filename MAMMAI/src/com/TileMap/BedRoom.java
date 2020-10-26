package com.TileMap;

import com.TileMap.TileMap;
import com.State.GameState;
import com.State.GameStateManage;
import com.company.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BedRoom extends GameState {

 //   private TileMap.Background bg ;
    private BufferedImage image;
    private Graphics2D g;
    private TileMap tileMap ;
    private Color titleColor ;
    private Font titleFont ;
    private Font font;

    private Background bg ;

    public BedRoom (GameStateManage gsm){
        this.gsm = gsm ;
        try {
            image = new BufferedImage(Main.WIDTH,Main.HEIGHT,BufferedImage.TYPE_INT_RGB);
            g = (Graphics2D) image.getGraphics() ;
            bg = new Background("/Resource/SKELD_MAP.jpg" , 2);

          tileMap = new TileMap("/MAMMAI/src/Resource/testmap.txt" , 32 );
          tileMap.loadTile("/MAMMAI/src/Resource/Key.gif");
           // bg = new TileMap.Background("/Resource/Bedroom.jpg" , 1);
            //  bg.setVector(-0.1,0);

        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        tileMap.update();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Main.WIDTH,Main.HEIGHT);
        bg.draw(g);
        tileMap.draw(g);


    //    bg.draw(g);
    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }
}
