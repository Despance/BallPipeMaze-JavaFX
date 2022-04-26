package Tiles;

public class BlockTile extends Tile implements Movable{

    public BlockTile(int currentRow, int currentColumn) {
        super(currentRow, currentColumn, "/Block.png");
    }
}
