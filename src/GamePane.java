import Tiles.FreeTile;
import Tiles.Movable;
import Tiles.StarterTile;
import Tiles.Tile;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class GamePane extends Pane {

    private static boolean isMoving = false;

    int rowCount;
    int columnCount;
    int cellSize;

    int currentRow;
    int currentColumn;
    int spacing;

    Ball ball;


    public GamePane(int rowCount,int columnCount,int cellSize,int spacing){
        this.rowCount = rowCount;
        this.columnCount=columnCount;
        this.cellSize=cellSize;
        this.spacing = spacing;
    }



    public void add(Tile e){
        super.getChildren().add(e);
        //e.setPreserveRatio(true);
        e.setFitWidth(cellSize);
        e.setFitHeight(cellSize);
        e.setTranslateX(currentRow*(cellSize+spacing));
        e.setTranslateY(currentColumn*(cellSize+spacing));

        e.setCurrentRow(currentRow);
        e.setCurrentRow(currentColumn);

        System.out.println(currentRow+ " "+ currentColumn);

        currentRow++;
        if(currentRow==rowCount){
            currentRow=0;
            currentColumn++;
        }

    }

    public void addBall( Ball ball){
        this.ball = ball;
        super.getChildren().add(ball);
        ball.toFront();
        StarterTile starterTile = null;
        for (Node tile :getChildren()){
            if (tile instanceof StarterTile ){
                starterTile = (StarterTile) tile;
                break;
            }

        }
        if (starterTile!=null){

            ball.setTranslateX(starterTile.getTranslateX()+50);
            ball.setTranslateY(starterTile.getTranslateY()+50);
        }

    }

    public void drawLine(){
        Path path = makeLine();

        getChildren().add(path);
        path.toFront();
        path.setTranslateX(ball.getTranslateX());
        path.setTranslateY(ball.getTranslateY());
    }

    public Path makeLine(){
        Path path = new Path();
        path.getElements().add(new MoveTo(0,0));

        Tile currentTile= null;
        boolean canMove = true;
        for (Node tile :getChildren()){
            if (tile instanceof StarterTile){
                currentTile = (Tile) tile;
                break;
            }
        }

        Tile nextTile = null;

            if(currentTile!= null){


                int row = currentTile.getCurrentRow();
                int column = currentTile.getCurrentColumn();


                 Tile.Direction nextDirection = currentTile.getEnumDirection();
                 switch (nextDirection){
                     case DOWN:
                         column++;
                         break;
                 }



                for (Node tilex : getChildren()){

                    if(tilex instanceof Tile){
                        Tile tile  = (Tile) tilex;
                        if(tile.getCurrentRow() == row && tile.getCurrentColumn() == column){
                            nextTile = tile;

                            break;
                        }
                    }

                }

                if(nextTile!=null){
                    System.out.println("girdi");
                    System.out.println(nextTile.getCurrentRow()+" "+nextTile.getCurrentColumn());
                    System.out.println(nextTile.getEnumDirection());
                    if(nextTile.getEnumDirection() == Tile.Direction.VERTICAL){
                        System.out.println("girdi");
                        path.getElements().add(new LineTo(100*nextTile.getCurrentColumn(),100*nextTile.getCurrentRow()));
                    }
                }else{
                    canMove= false;
                }




            }


        return path;

    }



    public void changeTiles(Tile t,String d){


            if (!isMoving && t instanceof Movable && !(t instanceof FreeTile)){

                int tempRow = t.getCurrentRow();
                int tempColumn = t.getCurrentColumn();


                Tile changedTile = null;
                for(Node tile : getChildren()){
                    Tile currentTile = null;
                    if (tile instanceof FreeTile){
                        currentTile = (Tile) tile;
                    }


                    if(currentTile!=null){


                        switch (d){
                            case "Up":
                                if(currentTile.getCurrentColumn()==tempColumn && currentTile.getCurrentRow() ==tempRow-1)
                                    changedTile=currentTile;
                                break;
                            case "Down":
                                if(currentTile.getCurrentColumn()==tempColumn && currentTile.getCurrentRow() ==tempRow+1)
                                    changedTile=currentTile;
                                break;
                            case "Right":
                                if(currentTile.getCurrentColumn()==tempColumn+1 && currentTile.getCurrentRow() ==tempRow)
                                    changedTile=currentTile;
                                break;
                            case "Left":
                                if(currentTile.getCurrentColumn()==tempColumn-1 && currentTile.getCurrentRow() ==tempRow)
                                    changedTile=currentTile;
                                break;
                        }
                    }


                }

                if(changedTile!=null){
                    double tempX = t.getTranslateX();
                    double tempY = t.getTranslateY();
                    double tX = changedTile.getTranslateX();
                    double tY = changedTile.getTranslateY();

                    isMoving= true;
                    t.toFront();
                    TranslateTransition translate = new TranslateTransition();
                    translate.setToX(tX);
                    translate.setToY(tY);
                    translate.setNode(t);
                    translate.setDuration(Duration.millis(500));
                    translate.play();

                    t.setCurrentRow(changedTile.getCurrentRow()) ;
                    t.setCurrentColumn(changedTile.getCurrentColumn());
                    //System.out.println(tempX + " "+ tempY);
                    TranslateTransition translateB = new TranslateTransition();
                    translateB.setToX(tempX);
                    translateB.setToY(tempY);
                    translateB.setNode(changedTile);
                    translateB.setDuration(Duration.millis(500));
                    translateB.play();
                    translate.setOnFinished(event -> isMoving=false);

                    changedTile.setCurrentRow(tempRow);
                    changedTile.setCurrentColumn(tempColumn);

                }
            }









    }



}
