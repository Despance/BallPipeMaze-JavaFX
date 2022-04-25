import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class End implements Tiles{




    public ImageView getImage(){
        Image image = new Image("");
        ImageView tile = new ImageView(image);
        tile.setFitHeight(100);
        tile.setFitWidth(100);
        return tile;
    }

    public boolean isMovable(){
        return false;
    }
}
