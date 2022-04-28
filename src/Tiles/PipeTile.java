package Tiles;

import javafx.scene.image.Image;

public class PipeTile extends Tile implements Movable{


    public PipeTile(int currentRow, int currentColumn, String type) {
          super(currentRow, currentColumn,"/PipeVertical.png" );
        // super(currentRow, currentColumn,"/Pipe.png");

        if (type.equals("Horizontal")) {
            setEnumDirection(Direction.HORIZONTAL);
            super.setImage(new Image("/PipeHorizontal.png"));
            System.out.println("Horizontal");
        }
        else {
            setEnumDirection(Direction.VERTICAL);
            System.out.println("Vertical");
        }





    }
}
