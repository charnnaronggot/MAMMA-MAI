package com.company;

import com.TileMap.TileMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Player {

    private int x;
    private int y;
    private double speedX;
    private double speedY;
    private double speed = 2;
    private double maxSpeed;
    private double stopSpeed;

    private int Height = 22;
    private int Width = 22;

    boolean leaf = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;

    private TileMap tileMap;

    private boolean topLeaf;
    private boolean topRight;
    private boolean bottomLeaf;
    private boolean bottomRight;

    private PlayerAnimation animation;
    private BufferedImage[] walkingSprite;
    private BufferedImage[] idleSprite;
    private boolean facingLeaf;

    public Player(TileMap tm) {

        tileMap = tm;
        this.x = 100;
        this.y = 100;

        try {

            idleSprite = new BufferedImage[1];
            walkingSprite = new BufferedImage[6];

            idleSprite[0] = ImageIO.read(new File("src/Resource/kirbyidle.gif"));

            BufferedImage image = ImageIO.read(new File("src/Resource/kirbywalk.gif"));
            for (int i = 0; i < walkingSprite.length; i++) {
                walkingSprite[i] = image.getSubimage(
                        i * Width + i,
                        0,
                        Width,
                        Height
                );
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        animation = new PlayerAnimation();
        facingLeaf = false;
    }

    public void update() {
//if(leaf){
//    speedX -= speed ;
//
//}else if (right){
//    speedX += speed ;
//
//}else if (up){
//    speedY -= speed ;
//}else if (down){
//    speedY -= speed ;
//}
        x += speedX;
        y += speedY;

        if(x == TileMap.getx() && y == TileMap.gety()){
            System.out.println("kuy");
        }

        if (x <= 0 ||x > Main.WIDTH) {
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

        //spite animation ;
        if (leaf || right || up || down) {
            animation.setFrames(walkingSprite);
            animation.setDelay(100);
        } else {
            animation.setFrames(idleSprite);
            animation.setDelay(-1);
        }

//            if(x<0 || x>= Main.WIDTH){
//                speedX = 0 ;
//
//
//            }else if (y < 0 || y >= Main.HEIGHT )
//                speedY = 0 ;
//
        animation.update();
        if (speedX < 0) {
            facingLeaf = true;
        }
        if (speedX > 0) {
            facingLeaf = false;
        }
//        //check collisions
//        int currCol = tileMap.getColTile((int)x);
//        int currRow = tileMap.getRowTile((int)y);
//
//        double tox = x + speedX;
//        double toy = y + speedY;
//
//        double tempx = x;
//        double tempy = y;
//
//        calculateCorners(x, toy);
//
//        if (speedY < 0) {
//            if (topLeaf || topRight) {
//                speedY = 0;
//                tempy = currRow * tileMap.getTileSize() + Height / 2;
//            } else {
//                tempy += speedY;
//            }
//        }
//        if (speedY > 0) {
//            if (bottomLeaf || bottomRight) {
//                speedY = 0;
//
//            }
//        }
    }



    //Draw the player ;
        public void draw (Graphics2D g){
//
            int tx = 0;
            int ty = 0;
//
            if (facingLeaf) {
                g.drawImage(animation.getImage(),
                        (int) (tx + x - Width / 2),
                        (int) (ty + y - Height / 2),
                        null
                );

            } else {
                g.drawImage(
                        animation.getImage(),
                        (int) (tx + x - Width / 2 + Width),
                        (int) (ty + y - Height / 2),
                        -Width, Height
                        , null

                );
            }
//
//       g.setColor(Color.RED);
//       g.drawRect(x, y, 32, 32);
        }

        public void keyPressed (KeyEvent e){
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_A) {

                speedX = -speed;
                leaf = true;

            }
            if (keyCode == KeyEvent.VK_D) {
                speedX = speed;
                right = true;

            }
            if (keyCode == KeyEvent.VK_W) {
                speedY = -speed;
                up = true;

            }
            if (keyCode == KeyEvent.VK_S) {
                speedY = speed;
                down = true;

            }
//        if (keyCode == KeyEvent.VK_SPACE) {
//            GamePanel.tracking = true;
//            GamePanel.x = x ;
//            GamePanel.y = y ;
//        }
//        if(GamePanel.y >= 100 && GamePanel.y <= 200 && GamePanel.x == 500  ){
//
//        }

        }


        public void keyReleased (KeyEvent e){
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_A) {
                speedX = 0;
                leaf = false;

            }
            if (keyCode == KeyEvent.VK_D) {
                speedX = 0;
                right = false;
            }
            if (keyCode == KeyEvent.VK_W) {
                speedY = 0;
                up = false;
            }
            if (keyCode == KeyEvent.VK_S) {
                speedY = 0;
                down = false;
            }


        }
    private void calculateCorners(double x, double toy) {
        int leafTile = tileMap.getColTile((int) (x - Width / 2));
        int rightTile = tileMap.getColTile((int) (x + Width / 2) + 1);
        int topTile = tileMap.getRowTile((int) (y - Height / 2));
        int bottomTile = tileMap.getRowTile((int) (y + Height / 2) + 1);
        topLeaf = tileMap.getTile(topTile, leafTile) == 0;
        topRight = tileMap.getTile(topTile, rightTile) == 0;
        bottomLeaf = tileMap.getTile(bottomTile, leafTile) == 0;
        bottomRight = tileMap.getTile(bottomTile, rightTile) == 0;
    }

    }



