package Tiles;

public class CurvedPipeTile extends Tile implements Movable{

    public CurvedPipeTile(int currentRow, int currentColumn, String type) {
        super(currentRow, currentColumn, "/CurvedPipe.png");

        switch(type){
            case "00":

                setEnumDirection(Direction.UP_LEFT);
                break;
            case "01":

                setEnumDirection(Direction.UP_RIGHT);
                break;
            case "10":

                setEnumDirection(Direction.DOWN_RIGHT);
                break;
            case "11":

                setEnumDirection(Direction.DOWN_lEFT);
                break;

        }
    }
}
