package Tiles;

import javafx.scene.image.Image;

public class EndTile extends Tile{

    // here we determine which image to call, determine which direction this tile has and call the super constructor
    public EndTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/EndHorizontal.png");

        if (type.equals("vertical")) {
            super.setImage(new Image("/EndVertical.png"));
            setDirection(type);
        }
        else

            setDirection(type);
    }
}
