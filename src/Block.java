import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Block implements Empty{

    int currentRow;
    int currentColumn;

    public double startX;
    public double startY;
    public double finishX;
    public double finishY;

    Image image;
    ImageView imageView;
    public ImageView getImage(){
        image = new Image("/Block.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        return imageView;
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