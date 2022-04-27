package Tiles;

public class CurvedPipeTile extends Tile implements Movable{

    public CurvedPipeTile(int currentRow, int currentColumn, String type) {
        super(currentRow, currentColumn, "/CurvedPipe.png");
        switch(type){
            case "00":
                rotateTile(180);
                break;
            case "01":
                rotateTile(270);
                break;
            case "10":
                rotateTile(0);
                break;
            case "11":
                rotateTile(90);
                break;

        }
    }
}
