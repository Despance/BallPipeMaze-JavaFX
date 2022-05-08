package Tiles;

import javafx.scene.input.MouseEvent;

public class EmptyTile extends Tile implements Movable{
    // here we determine which image we to call and we call the super constructor
    public EmptyTile(int currentRow, int currentColumn) {
        super(currentRow, currentColumn, "/GreyBlock.png");



    }


}
