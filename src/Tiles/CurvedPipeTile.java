package Tiles;

public class CurvedPipeTile extends Tile implements Movable{

    public CurvedPipeTile(int currentRow, int currentColumn, String type) {
        super(currentRow, currentColumn, "/CurvedPipe.png");
        Direction enumDirection;
        switch(type){
            case "00":
                rotateTile(180);
                enumDirection = Direction.UP_LEFT;
                break;
            case "01":
                rotateTile(270);
                enumDirection = Direction.UP_RIGHT;
                break;
            case "10":
                rotateTile(0);
                enumDirection = Direction.DOWN_LEFT;
                break;
            case "11":
                rotateTile(90);
                enumDirection = Direction.DOWN_RIGHT;
                break;

        }
    }
}
