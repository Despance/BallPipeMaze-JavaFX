import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

    private String direction;

    public Ball(double xPos,double yPos,double radius){
        super(xPos,yPos,radius);
        super.setTranslateX(xPos);
        super.setTranslateY(yPos);
        super.setFill(Color.AQUA);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
