package State.Room;

import com.State.GameState;
import com.State.GameStateManage;

import java.awt.*;

public class Hall extends GameState {

    private TileMap.Background bg ;


    public Hall (GameStateManage gsm){
        this.gsm = gsm ;
        try {
            bg = new TileMap.Background("/Resource/Bedroom.jpg" , 1);
            //  bg.setVector(-0.1,0);

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }
}
