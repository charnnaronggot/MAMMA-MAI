package TileMap;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage image ;
    private boolean blocked ;

    public  Tile (BufferedImage image , Boolean blocked){
        this.image = image ;
        this.blocked = blocked ;
    }
    public BufferedImage getImage(){
        return  image ;
    }
    public Boolean isBlocked (){ return  blocked ;


    }

}
