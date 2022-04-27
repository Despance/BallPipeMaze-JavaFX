package Tiles;

import javafx.scene.image.Image;

public class PipeStaticTile extends Tile{

    public PipeStaticTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/StaticPipeVertical.png");

        if (type.equals("Horizontal")) {
            super.setImage(new Image("/StaticPipeHorizontal.png"));
            setEnumDirection(Direction.HORIZONTAL);
        }
        else
            setEnumDirection(Direction.VERTICAL);

    }
}
