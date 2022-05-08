package Tiles;


import javafx.scene.image.Image;

public class StarterTile extends Tile {


    // here we determine which image to call, determine which direction this tile has and call the super constructor
    public StarterTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/StarterHorizontal.png");
        if (type.equals("vertical")) {
            super.setImage(new Image("/StarterVertical.png"));
            setDirection(type);

        }
        else{
            setDirection(type);

        }




    }






}
