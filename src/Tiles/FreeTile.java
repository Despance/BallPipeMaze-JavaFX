package Tiles;

public class FreeTile extends Tile implements Movable{
    // here we determine which image we to call and we call the super constructor
    public FreeTile(int currentRow, int currentColumn) {
        super(currentRow, currentColumn, "/Free.png");



    }
}
