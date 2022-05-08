package Tiles;

import javafx.scene.image.Image;

public class CurvedPipeStaticTile extends Tile{
    // here we determine which image to call, determine which direction this tile has and call the super constructor
    public CurvedPipeStaticTile(int currentRow, int currentColumn, String type ) {
        super(currentRow, currentColumn, "/StaticCurvedPipe11.png");

        switch(type){
            case "00":

                super.setImage(new Image("/StaticCurvedPipe00.png"));
                setDirection(type);
                break;
            case "01":

                super.setImage(new Image("/StaticCurvedPipe01.png"));
                setDirection(type);
                break;
            case "10":

                super.setImage(new Image("/StaticCurvedPipe10.png"));
                setDirection(type);
                break;
            case "11":

                setDirection(type);
                break;
        }



    }
}
