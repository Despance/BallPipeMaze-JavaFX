import javafx.application.Application;
import javafx.scene.image.*;
import javafx.stage.*;

public class Pipe  implements Tiles, Movable{

    int currentRow;
    int currentColumn;

    public double startX;
    public double startY;
    public double finishX;
    public double finishY;
    public Pipe(){

    }

    public ImageView getImage(){
        Image image = new Image("Pipe.png");
        ImageView tile = new ImageView(image);
        tile.setFitHeight(100);
        tile.setFitWidth(100);
        return tile;
    }

    public boolean isMovable(){
        return true;
    }

    public String checkDirection(){
        double degree = Math.atan2(finishY-startY, finishX- startX);

        if(degree< Math.PI/4 && degree>-Math.PI/4){
            System.out.println("Right");
            return "Right";
        } else if (degree< Math.PI*3/4 && degree>Math.PI/4) {
            System.out.println("Down");
            return "Down";
        }else if(degree>-Math.PI*3/4 && degree<-Math.PI/4){
            System.out.println("Up");
            return "Up";
        }else if(degree< Math.PI*3/4 || degree>-Math.PI*3/4){
            System.out.println("Left");
            return "Left";
        }else{
            return null;
        }



    }

}
