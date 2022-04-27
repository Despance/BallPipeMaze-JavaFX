package Tiles;

public class PipeTile extends Tile implements Movable{


    public PipeTile(int currentRow, int currentColumn, String type) {
        super(currentRow, currentColumn,"/Pipe.png");
        Direction enumDirection;
        if (type.equals("Horizontal")) {
            super.rotateTile(90);
            enumDirection = Direction.LEFT_RIGHT;
        }
        else
            enumDirection = Direction.UP_DOWN;






    }
}
