package Tiles;

public class PipeStaticTile extends Tile{

    public PipeStaticTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/PipeStatic.png");
        if (type.equals("Vertical")) {
            super.rotateTile(90);
        }

    }
}
