package Tiles;

import javafx.scene.image.Image;

public class PipeStaticTile extends Tile{

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
