package State;


import java.awt.*;
import java.awt.event.KeyEvent;

import TileMap.Background;
import com.State.GameState;
import com.State.GameStateManage;
import com.company.Main;

public class MenuState extends GameState {

    private Background bg ;
    private int currentChoice ;

    private String[] options = {
            "START",
            "Help",
            "QUITE"
    };


    private Color titleColor ;
    private Font titleFont ;
    private Font font;
    public MenuState(GameStateManage gsm){

        this.gsm = gsm ;
        try {
            bg = new Background("/Resource/BGMENU.jpg" , 1);
          //  bg.setVector(-0.1,0);

            titleColor = new Color(128,0,0);
            titleFont = new Font("Bauhaus 93" ,
                    Font.PLAIN , 82);
            font = new Font ("Bauhaus 93", Font.PLAIN , 44);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public void init() {

    }
    @Override
    public void update() {
       // bg.update();
    }

    @Override
    public void draw(Graphics2D g) {
        //draw background ;

        bg.draw(g);
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("MAMMA MAI!",Main.WIDTH -700,Main.HEIGHT / 4);
        g.setFont(font);
            for(int i = 0 ; i < options.length ; i++){
                if(i == currentChoice){
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.RED);
                }
                g.drawString(options[i] , Main.WIDTH/3, + Main.HEIGHT /2 -100 + ( i *80));
            }

    }

    private void select(){
        if(currentChoice == 0){
            gsm.setState(1);
        }
        if(currentChoice == 1){

        }
        if(currentChoice == 2){
            System.exit(0);
        }
    }
    @Override
    public void keyPressed(int key) {
        if(key == KeyEvent.VK_ENTER){
            select();
        }if(key == KeyEvent.VK_UP){
           currentChoice--;
           if(currentChoice == -1 ){
               currentChoice = options.length - 1 ;
           }
        }
        if(key == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == options.length ){
                currentChoice = 0 ;
            }
        }
    }

    @Override
    public void keyReleased(int key) {

    }
}
