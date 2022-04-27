package Tiles;

public class EmptyTile extends Tile implements Movable{

    public EmptyTile(int currentRow, int currentColumn) {
        super(currentRow, currentColumn, "/Block.png");
    }
}
