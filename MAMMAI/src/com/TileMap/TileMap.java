package com.TileMap ;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TileMap {
    public static boolean isBlocked;
    private static int x;
    private static int y ;

    private int tileSize;
    private int [][]map;
    public static int mapHeight;
    public static   int mapWidth;

    private BufferedImage tileset ;
    private Tile[][] tiles;

    private int numRowsToDraw;
    private int numColsToDraw;

    private double tween;

    public TileMap(String s, int tileSize) {
        this.tileSize = tileSize;
        try {
          //  InputStream in = getClass().getResourceAsStream(s);
            BufferedReader br = new BufferedReader(new FileReader(s));
            mapWidth = Integer.parseInt(br.readLine());
            mapHeight = Integer.parseInt(br.readLine());
            map = new int[mapHeight][mapWidth] ;

            String delimiters = "\\s+";
            for (int row = 0 ; row < mapHeight ; row++ ){
                String line = br.readLine();
                String[] tokens = line.split(delimiters);
                for(int col = 0 ; col < mapWidth ; col++){
                    map[row][col] = Integer.parseInt(tokens[col]);
                   // System.out.println(tokens[col]);
                }
             //   System.out.println(" \n ");
            }
        }catch ( Exception e ){
            e.printStackTrace();

        }


    }

    public void loadTile(String s ){
        try{
            tileset = ImageIO.read(new File(s));
            int countWidth = tileset.getWidth();
            int countHeight = tileset.getHeight();
            int numTileAcross = (tileset.getWidth() +1) / (tileSize+1 ) ;
            tiles = new Tile[10][numTileAcross] ;
            BufferedImage subimage ;
            for(int col = 0 ; col < numTileAcross ; col ++ ){
                subimage = tileset.getSubimage(
                        col * tileSize + col ,
                        0 ,
                        tileSize ,
                        tileSize);
                tiles[0][col] = new Tile(subimage ,false );
//                subimage = tileset.getSubimage(
//                        col * tileSize + col ,
//                        tileSize * 1,
//                        tileSize ,
//                        tileSize) ;
//                tiles[1][col] = new Tile(subimage ,false );
//                subimage = tileset.getSubimage(
//                        col * tileSize + col ,
//                        tileSize * 2,
//                        tileSize ,
//                        tileSize) ;
//                tiles[2][col] = new Tile(subimage ,false );
//                subimage = tileset.getSubimage(
//                        col * tileSize + col ,
//                        tileSize * 3,
//                        tileSize ,
//                        tileSize) ;
//                tiles[3][col] = new Tile(subimage ,false );
//                subimage = tileset.getSubimage(
//                        col * tileSize + col ,
//                        tileSize * 4,
//                        tileSize ,
//                        tileSize) ;
//                tiles[4][col] = new Tile(subimage ,false );
//                subimage = tileset.getSubimage(
//                        col * tileSize + col ,
//                        tileSize * 5,
//                        tileSize ,
//                        tileSize) ;
//                tiles[5][col] = new Tile(subimage ,false );
//                subimage = tileset.getSubimage(
//                        col * tileSize + col ,
//                        tileSize * 6,
//                        tileSize ,
//                        tileSize) ;
//                tiles[6][col] = new Tile(subimage ,false );
//                subimage = tileset.getSubimage(
//                        col * tileSize + col ,
//                        tileSize * 7,
//                        tileSize ,
//                        tileSize) ;
//                tiles[7][col] = new Tile(subimage ,false );
//                subimage = tileset.getSubimage(
//                        col * tileSize + col ,
//                        tileSize * 8,
//                        tileSize ,
//                        tileSize) ;
                tiles[8][col] = new Tile(subimage , true );
            }
            System.out.println(numTileAcross );
            System.out.println(countWidth);
            System.out.println(countHeight);
            System.out.println(x / tileSize);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static int getx(){ return  x ;}
    public static int gety(){ return  y ;}

    public int getColTile(int x){
        return (x / tileSize );
    }
    public  int getRowTile(int y){
        return y / tileSize ;
    }
    public int getTile (int row , int col ){
        return  map[row][col] ;
    }
    public int getTileSize(){
        return  tileSize ;
    }

    public void setx(int i ){
        x = i  ;
    }
    public  void sety(int i){
        y = i ;
    }


    public  boolean isBlocked (int row , int col  ){
        int rc = map [row][col] ;
        int r = rc / tiles[0].length ;
        int c = rc % tiles[0].length ;
        return tiles[r][c].isBlocked();
    }
    public void update() {

    }

    public void draw (Graphics2D g ){

        for (int row = 0 ; row < mapHeight ; row++ ){

            for(int col = 0 ; col < mapWidth ; col ++ ){
                int rc = map[row][col];

                int r = rc / tiles[0].length ;
                int c = rc % tiles[0].length ;
            try {
                g.drawImage(
                        tiles[r][c].getImage(),
                        (int) x + col * tileSize,
                        (int) y + row * tileSize,
                        null);

            }catch (Exception e){

            }
            }
        }

    }

}
