package com.company;

import com.State.GameState;
import com.State.GameStateManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable , KeyListener {
    //make a tracking system;
    public static boolean tracking = false;
    public static int x ;
    public static int y ;
    Player player ;
    Enemy enemy ;
    GameState gameState ;

    public static  final  int  WIDTH = 800 ;
    public static final int HEIGHT = 800 ;
    private Thread thread ;
    private boolean running = false;

    long start ;
    long elapsed ;
    long wait ;

    private BufferedImage image;
    private Graphics2D g;

    private int FPS = 30;
    private double averrageFPS = 30;
    private int targetTime = 1000/ FPS ;

    private GameStateManage gsm ;
    //initialize
    public GamePanel(){
        super();
        setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
        setFocusable(true);
        requestFocus();

//        loop = new Timer(10 , (ActionListener) this);
//        loop.start();
//        player = new Player(100,100);
//        enemy = new Enemy(200,200) ;
//        addKeyListener(new KeyPress(player));
//        setFocusable(true);
//        requestFocus();
    }
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            addKeyListener(this);
            thread = new Thread(this);
            thread.start();
        }
    }
    // Graphics Compile ;


    private void init (){
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics() ;
        running = true;
        gsm = new GameStateManage();

        }

    // Loop Game ;
    @Override
    public void run() {
        init();
        while(running) {

            start = System.nanoTime();
            update();
            draw();
            drawToScreen();
            elapsed = (System.nanoTime() - start) / 1000000 ;

            wait = targetTime - elapsed/1000000 ;


            try {
                Thread.sleep(wait);
            }catch (Exception e ){
                e.printStackTrace();
            }
//            player.update();
//            enemy.update();
//            repaint();
        }
    }

    private void update(){
       gsm.update();
    }
    private void draw(){
      gsm.draw(g);
    }
    private void drawToScreen(){
        Graphics g2 = getGraphics() ;
        g2.drawImage(image,0,0,null);
        g2.dispose();
    }















    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        gsm.keyPressed(key.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent key) {
        gsm.keyReleased(key.getKeyCode());
    }
}
