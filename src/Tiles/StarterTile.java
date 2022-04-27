package Tiles;


public class StarterTile extends Tile {



    public StarterTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/Starter.png");
        Direction enumDirection;
        if (type.equals("Vertical")) {
            super.rotateTile(90);
            enumDirection = Direction.DOWN;
        }
        else
            enumDirection = Direction.UP;



    }




}
