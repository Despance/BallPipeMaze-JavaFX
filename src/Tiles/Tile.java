package Tiles;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;



public class Tile extends ImageView {
    public enum Direction{
        UP,DOWN,RIGHT,LEFT,VERTICAL,HORIZONTAL,UP_RIGHT,DOWN_RIGHT,UP_LEFT,DOWN_lEFT
    }

    private int currentRow;
    private int currentColumn;

    private double startX;
    private double startY;
    private double finishX;
    private double finishY;

    private int size;

    private Direction enumDirection;




    public Tile(int currentRow,int currentColumn,String url){
        super(url);
        this.currentColumn = currentColumn;
        this.currentRow = currentRow;
        super.setFitWidth(size);
        super.setFitHeight(size);

    }



    public String checkDirection(){
        double degree = -Math.atan2(finishY-startY, finishX- startX);

        System.out.println(degree);

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






    public void rotateTile(int degree){
        this.setRotate(degree);

    }

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

    public Direction getEnumDirection() {
        return enumDirection;
    }

    public void setEnumDirection(Direction enumDirection) {
        this.enumDirection = enumDirection;
    }
}
