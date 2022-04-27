package Tiles;

public class EndTile extends Tile{


    public EndTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/End.png");

        if (type.equals("Vertical")) {
            setEnumDirection(Direction.LEFT);
        }
        else
            setEnumDirection(Direction.DOWN);
    }
}
