package Tiles;

public class CurvedPipeStaticTile extends Tile{
    public CurvedPipeStaticTile(int currentRow, int currentColumn, String type ) {
        super(currentRow, currentColumn, "/CurvedPipeStatic.png");

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
