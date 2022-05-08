package Tiles;

import javafx.scene.image.Image;

public class PipeTile extends Tile implements Movable{

    // here we determine which image to call, determine which direction this tile has and call the super constructor
    public PipeTile(int currentRow, int currentColumn, String type) {
        super(currentRow, currentColumn,"/PipeVertical.png" );

        if (type.equals("horizontal")) {
            super.setDirection("horizontal");
            super.setImage(new Image("/PipeHorizontal.png"));
           System.out.println("Horizontal created");
        }
        else {
            setDirection("vertical");
            System.out.println("vertical created");
            System.out.println(getCurrentRow()+" "+getCurrentColumn());
        }





    }
}
