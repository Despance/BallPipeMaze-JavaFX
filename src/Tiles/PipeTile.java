package Tiles;

import javafx.scene.image.Image;

public class PipeTile extends Tile implements Movable{


    public PipeTile(int currentRow, int currentColumn, String type) {
          super(currentRow, currentColumn,"/PipeVertical.png" );

        if (type.equals("horizontal")) {
            setDirection(type);
            super.setImage(new Image("/PipeHorizontal.png"));
            System.out.println("Horizontal");
        }
        else {
            setDirection(type);

            System.out.println("Vertical");
        }





    }
}
