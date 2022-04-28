package Tiles;

import javafx.scene.image.Image;

public class CurvedPipeTile extends Tile implements Movable{

    public CurvedPipeTile(int currentRow, int currentColumn, String type) {
        super(currentRow, currentColumn, "/CurvedPipe11.png");

        switch(type){
            case "00":

                super.setImage(new Image("/CurvedPipe00.png"));
                setDirection(type);
                break;
            case "01":

                super.setImage(new Image("/CurvedPipe01.png"));
                setDirection(type);
                break;
            case "10":

                super.setImage(new Image("/CurvedPipe10.png"));
                setDirection(type);
                break;
            case "11":

                setDirection(type);
                break;

        }
    }
}
