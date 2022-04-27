package Tiles;

public class EndTile extends Tile{


    public EndTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/End.png");
        Direction enumDirection;
        if (type.equals("Vertical")) {
            super.rotateTile(90);
            enumDirection = Direction.LEFT;
        }
        else
        enumDirection = Direction.RIGHT;
    }
}
