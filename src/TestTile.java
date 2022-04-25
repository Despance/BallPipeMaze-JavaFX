import javafx.scene.shape.Rectangle;

public class TestTile extends Rectangle {


    int currentRow;
    int currentColumn;

    public double startX;
    public double startY;
    public double finishX;
    public double finishY;

    TestTile(int x,int y,int width,int height){
        super(x,y,width,height);
    }


    String checkDirection(){
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
