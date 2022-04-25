import javafx.application.Application;
import javafx.scene.image.*;
import javafx.stage.*;

public class CurvedPipe  implements Tiles, Movable{

    public CurvedPipe(){

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
