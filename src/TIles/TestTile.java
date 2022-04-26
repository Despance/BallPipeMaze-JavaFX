package TIles;

import javafx.scene.shape.Rectangle;

public class TestTile extends Rectangle {


    public int currentRow;
    public int currentColumn;

    public double startX;
    public double startY;
    public double finishX;
    public double finishY;

    public TestTile(int x,int y,int width,int height){
        super(x,y,width,height);
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