import Tiles.*;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
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

        System.out.println(currentRow+ " "+ currentColumn+" "+e.getClass());

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

    }

    public Path makeLine(){
        Path path = new Path();


        boolean canMove = true;
        //Get current tile
        Tile currentTile= null;

        for (Node tile :getChildren()){
            if (tile instanceof StarterTile){
                currentTile = (Tile) tile;
                path.getElements().add(new MoveTo(100*currentTile.getCurrentColumn()+ball.getTranslateX(),100*currentTile.getCurrentRow()+ ball.getTranslateY()));

                if (currentTile.getDirection().equals("vertical")){
                    ball.setDirection("down");
                    path.getElements().add(new LineTo(100*currentTile.getCurrentColumn()+ball.getTranslateX(),100*currentTile.getCurrentRow()+50+ball.getTranslateY()));
                }else{
                    ball.setDirection("left");
                    path.getElements().add(new LineTo(100*currentTile.getCurrentColumn()-50+ball.getTranslateX(),100*currentTile.getCurrentRow()+ball.getTranslateY()));
                }


                break;
            }
        }

        //Find the next tile


        do {


        Tile nextTile = null;
        if(currentTile!= null){

            int row = currentTile.getCurrentRow();
            int column = currentTile.getCurrentColumn();



            switch (ball.getDirection()){
                case "down":
                    row++;
                    break;
                case "up":
                    row--;
                    break;
                case "right":
                    column++;
                    break;
                case "left":
                    column--;
                    break;
            }



            for (Node tilex : getChildren()){
                Tile tile = null;
                if (tilex instanceof Tile)
                    tile = (Tile)tilex;
                if (tile != null){
                    if (tile.getCurrentRow() == row && tile.getCurrentColumn() == column){
                        nextTile = tile;


                    }
                }


            }
            if(nextTile!=null){


                if(ball.getDirection().equals("up")||ball.getDirection().equals("down"))
                {
                    if (nextTile.getDirection().equals("vertical")){
                        if (nextTile instanceof EndTile)
                            path.getElements().add(new LineTo(100*nextTile.getCurrentColumn()+ball.getTranslateX(),100*nextTile.getCurrentRow()+ball.getTranslateY()));
                        else
                            path.getElements().add(new LineTo(100*nextTile.getCurrentColumn()+ball.getTranslateX(),100*nextTile.getCurrentRow()+50+ball.getTranslateY()));

                    }else {
                        ArcTo arcTo = new ArcTo();
                        switch (nextTile.getDirection()){
                            case "00":
                                if (ball.getDirection().equals("down")){
                                    ball.setDirection("left");
                                    arcTo.setX(nextTile.getCurrentColumn()*100-50+ball.getTranslateX());
                                    arcTo.setY(nextTile.getCurrentRow()*100+ball.getTranslateY());
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(false);
                                    arcTo.setLargeArcFlag(false);


                                }


                                break;
                            case "01":

                                if (ball.getDirection().equals("down")){
                                    ball.setDirection("right");

                                    arcTo.setX(nextTile.getCurrentColumn()*100+50+ball.getTranslateX());
                                    arcTo.setY(nextTile.getCurrentRow()*100+ball.getTranslateY());
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(false);
                                    arcTo.setLargeArcFlag(false);



                                }




                                break;
                            case "10":
                                if (ball.getDirection().equals("up")){
                                    ball.setDirection("left");
                                    arcTo.setX(nextTile.getCurrentColumn()*100+50+ball.getTranslateX());
                                    arcTo.setY(nextTile.getCurrentRow()*100+ball.getTranslateY());
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(true);
                                    arcTo.setLargeArcFlag(false);
                                }

                                break;
                            case "11":
                                if (ball.getDirection().equals("up")){
                                    ball.setDirection("right");
                                }

                                break;
                        }
                        path.getElements().add(arcTo);
                    }


                }else if(ball.getDirection().equals("right")||ball.getDirection().equals("left")){

                    if (nextTile.getDirection().equals("horizontal")){
                        if (nextTile instanceof EndTile)
                            path.getElements().add(new LineTo(100*nextTile.getCurrentColumn()+ball.getTranslateX(),100*nextTile.getCurrentRow()+ball.getTranslateY()));
                        else
                            path.getElements().add(new LineTo(100*nextTile.getCurrentColumn()+ball.getTranslateX()+50,100*nextTile.getCurrentRow()+ball.getTranslateY()));

                    }else{
                        ArcTo arcTo = new ArcTo();
                        switch (nextTile.getDirection()){
                            case "00":
                                if (ball.getDirection().equals("right")){
                                    ball.setDirection("up");
                                    arcTo.setX(nextTile.getCurrentColumn()*100+ball.getTranslateX());
                                    arcTo.setY(nextTile.getCurrentRow()*100-50+ball.getTranslateY());
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(false);
                                    arcTo.setLargeArcFlag(false);

                                }


                                break;
                            case "01":

                                if (ball.getDirection().equals("left")){
                                    ball.setDirection("up");
                                }

                                break;
                            case "10":
                                if (ball.getDirection().equals("right")){
                                    ball.setDirection("down");
                                }

                                break;
                            case "11":
                                if (ball.getDirection().equals("left")){
                                    ball.setDirection("down");
                                }

                                break;
                        }
                        path.getElements().add(arcTo);
                    }
                }
                System.out.println(currentTile.getCurrentRow()+" "+currentTile.getCurrentColumn()+" drawed " +currentTile.getClass());

                if (nextTile instanceof EndTile){
                    path.toBack();
                    ball.toFront();
                    canMove = false;
                    System.out.println("finish");
                    PathTransition pathTransition = new PathTransition();
                    pathTransition.setPath(path);
                    pathTransition.setNode(ball);
                    pathTransition.setDuration(Duration.millis(1000));
                    pathTransition.play();
                }else{
                    currentTile = nextTile;
                }




            }else{
                canMove = false;
            }
        }



        }while (canMove);


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
