package Tiles;

import javafx.scene.image.Image;

public class CurvedPipeStaticTile extends Tile{
    public CurvedPipeStaticTile(int currentRow, int currentColumn, String type ) {
        super(currentRow, currentColumn, "/StaticCurvedPipe11.png");

        switch(type){
            case "00":

                super.setImage(new Image("/StaticCurvedPipe00.png"));
                setEnumDirection(Direction.UP_LEFT);
                break;
            case "01":

                super.setImage(new Image("/StaticCurvedPipe01.png"));
                setEnumDirection(Direction.UP_RIGHT);
                break;
            case "10":

                super.setImage(new Image("/StaticCurvedPipe10.png"));
                setEnumDirection(Direction.DOWN_RIGHT);
                break;
            case "11":

                setEnumDirection(Direction.DOWN_lEFT);
                break;
        }



    }
}
