package Tiles;

import javafx.scene.image.ImageView;


// this is a superclass for our tiles
public class Tile extends ImageView {
    // here is our data field
    private int currentRow;
    private int currentColumn;
    private double startX;
    private double startY;
    private double finishX;
    private double finishY;
    private int size;
    private String direction;

    // this is our constructor
    public Tile(int currentRow,int currentColumn,String url){
        super(url);
        this.currentColumn = currentColumn;
        this.currentRow = currentRow;
        super.setFitWidth(size);
        super.setFitHeight(size);

    }



    //This method returns a direction according to the start and finish mouse positions.
    public String checkDirection(){

        //Get the degree between to points
        double degree = -Math.atan2(finishY-startY, finishX- startX);

        //Print and return the position
        if(degree< Math.PI/4 &&degree > 0|| degree>-Math.PI/4 && degree<0){
            System.out.println("Right");
            return "Right";
        } else if (degree> -Math.PI*3/4 && degree<-Math.PI/4) {
            System.out.println("Down");
            return "Down";
        }else if(degree<Math.PI*3/4 && degree>Math.PI/4){
            System.out.println("Up");
            return "Up";
        }else if(degree< Math.PI*3/4 || degree>-Math.PI*3/4){
            System.out.println("Left");
            return "Left";
        }else{
            return null;
        }
    }

    // setter and getter methods
    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getFinishX() {
        return finishX;
    }

    public void setFinishX(double finishX) {
        this.finishX = finishX;
    }

    public double getFinishY() {
        return finishY;
    }

    public void setFinishY(double finishY) {
        this.finishY = finishY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
