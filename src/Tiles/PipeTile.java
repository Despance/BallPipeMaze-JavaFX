package Tiles;

public class PipeTile extends Tile implements Movable{


    public PipeTile(int currentRow, int currentColumn, String type) {
        super(currentRow, currentColumn,"/Pipe.png");

        if (type.equals("Horizontal")) {
            setEnumDirection(Direction.HORIZONTAL);
        }
        else
            setEnumDirection(Direction.VERTICAL);






    }
}
