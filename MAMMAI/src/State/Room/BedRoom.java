package State.Room;

import TileMap.TileMap;
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

    public BedRoom (GameStateManage gsm){
        this.gsm = gsm ;
        try {

            image = new BufferedImage(Main.WIDTH,Main.HEIGHT,BufferedImage.TYPE_INT_RGB);
            g = (Graphics2D) image.getGraphics() ;


          tileMap = new TileMap("/MAMMAI/src/Resource/testmap2.txt" , 32 );
          tileMap.loadTile("/MAMMAI/src/Resource/free_tileset_version_10.png");
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
