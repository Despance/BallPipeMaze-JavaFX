package Tiles;

import javafx.scene.image.Image;

public class PipeStaticTile extends Tile{
    // here we determine which image to call, determine which direction this tile has and call the super constructor
    public PipeStaticTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/StaticPipeVertical.png");

        if (type.equals("horizontal")) {
            super.setImage(new Image("/StaticPipeHorizontal.png"));
            setDirection(type);
        }
        else
            setDirection(type);

    }
}
