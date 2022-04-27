package Tiles;


public class StarterTile extends Tile {



    public StarterTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/Starter.png");
        if (type.equals("Vertical")) {
            setEnumDirection(Direction.DOWN);
        }
        else{
            setEnumDirection(Direction.LEFT);
        }




    }






}
