import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle {



    public Ball(double xPos,double yPos,double radius){
        super(xPos,yPos,radius);
        super.setTranslateX(xPos);
        super.setTranslateY(yPos);
        super.setFill(Color.AQUA);
    }




}
