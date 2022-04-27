package Tiles;

public class PipeStaticTile extends Tile{

    public PipeStaticTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/PipeStatic.png");
        Direction enumDireciton;
        if (type.equals("Horizontal")) {
            super.rotateTile(90);
            enumDireciton = Direction.LEFT_RIGHT;
        }
        else
            enumDireciton = Direction.UP_DOWN;

    }
}
