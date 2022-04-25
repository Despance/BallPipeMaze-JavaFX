import javafx.application.Application;
import javafx.scene.image.*;
import javafx.stage.*;

public class Pipe  implements Tiles, Movable{

    public Pipe(){

    }

    public ImageView getImage(){
        Image image = new Image("");
        ImageView tile = new ImageView(image);
        tile.setFitHeight(100);
        tile.setFitWidth(100);
        return tile;
    }

    public boolean isMovable(){
        return true;
    }
}
