package State.Room;

import com.State.GameState;
import com.State.GameStateManage;

import java.awt.*;

public class BedRoom extends GameState {

    private TileMap.Background bg ;

    private Color titleColor ;
    private Font titleFont ;
    private Font font;

    public BedRoom (GameStateManage gsm){
        this.gsm = gsm ;
        try {
            bg = new TileMap.Background("/Resource/Bedroom.jpg" , 1);
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

    }

    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);
    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }
}
