package Tiles;

public class PipeStaticTile extends Tile{

    public PipeStaticTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/PipeStatic.png");

        if (type.equals("Horizontal")) {
            setEnumDirection(Direction.HORIZONTAL);
        }
        else
            setEnumDirection(Direction.VERTICAL);

    }
}
