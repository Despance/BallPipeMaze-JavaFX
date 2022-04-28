package Tiles;


import javafx.scene.image.Image;

public class StarterTile extends Tile {



    public StarterTile(int currentRow, int currentColumn,String type) {
        super(currentRow, currentColumn, "/StarterHorizontal.png");
        if (type.equals("Vertical")) {
            super.setImage(new Image("/StarterVertical.png"));
            setDirection(type);

        }
        else{
            setDirection(type);

        }




    }






}
