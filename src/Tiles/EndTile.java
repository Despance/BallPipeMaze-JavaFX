package Tiles;

import javafx.scene.image.Image;

public class EndTile extends Tile{


    public EndTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/EndHorizontal.png");

        if (type.equals("Vertical")) {
            super.setImage(new Image("/EndVertical.png"));
            setDirection(type);
        }
        else

            setDirection(type);
    }
}
