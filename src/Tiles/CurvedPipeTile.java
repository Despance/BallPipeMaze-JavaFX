package Tiles;

import javafx.scene.image.Image;

public class CurvedPipeTile extends Tile implements Movable{

    public CurvedPipeTile(int currentRow, int currentColumn, String type) {
        super(currentRow, currentColumn, "/CurvedPipe11.png");

        switch(type){
            case "00":

                super.setImage(new Image("/CurvedPipe00.png"));
                setEnumDirection(Direction.UP_LEFT);
                break;
            case "01":

                super.setImage(new Image("/CurvedPipe01.png"));
                setEnumDirection(Direction.UP_RIGHT);
                break;
            case "10":

                super.setImage(new Image("/CurvedPipe10.png"));
                setEnumDirection(Direction.DOWN_RIGHT);
                break;
            case "11":

                setEnumDirection(Direction.DOWN_lEFT);
                break;

        }
    }
}
