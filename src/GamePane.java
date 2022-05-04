import Tiles.*;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class GamePane extends Pane {

    private static boolean isMoving = false;

    private int rowCount;
    private int columnCount;
    private int cellSize;

    private int currentRow;
    private int currentColumn;
    private int spacing;

    private int numberOfMoves = 0;

    private boolean levelSolved = false;

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
        //path.setVisible(false);

        boolean canMove = true;
        //Get current tile
        Tile currentTile= null;

        for (Node tile :getChildren()){
            if (tile instanceof StarterTile){
                currentTile = (Tile) tile;
                path.getElements().add(new MoveTo(100*currentTile.getCurrentColumn()+50,100*currentTile.getCurrentRow()+50));

                if (currentTile.getDirection().equals("vertical")){
                    ball.setDirection("down");
                    path.getElements().add(new LineTo(100*currentTile.getCurrentColumn()+50,100*currentTile.getCurrentRow()+100));
                }else{
                    ball.setDirection("left");
                    path.getElements().add(new LineTo(100*currentTile.getCurrentColumn(),100*currentTile.getCurrentRow()+50));
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
            if(nextTile!=null && nextTile.getDirection() != null){


                switch (ball.getDirection()) {
                    case "up":
                        if (nextTile.getDirection().equals("vertical")) {
                            if (nextTile instanceof EndTile)
                                path.getElements().add(new LineTo(100 * nextTile.getCurrentColumn() + 50, 100 * nextTile.getCurrentRow() + 50));
                            else
                                path.getElements().add(new LineTo(100 * nextTile.getCurrentColumn() + 50, 100 * nextTile.getCurrentRow()));

                        } else {
                            ArcTo arcTo = new ArcTo();
                            switch (nextTile.getDirection()) {
                                case "10":
                                    ball.setDirection("left");
                                    arcTo.setX(nextTile.getCurrentColumn() * 100);
                                    arcTo.setY(nextTile.getCurrentRow() * 100 + 50);
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(false);
                                    arcTo.setLargeArcFlag(false);


                                    break;
                                case "11":
                                    if (ball.getDirection().equals("up")) {
                                        ball.setDirection("right");
                                        arcTo.setX(nextTile.getCurrentColumn() * 100 + 100);
                                        arcTo.setY(nextTile.getCurrentRow() * 100 + 50);
                                        arcTo.setXAxisRotation(50);
                                        arcTo.setRadiusX(50);
                                        arcTo.setRadiusY(50);
                                        arcTo.setSweepFlag(true);
                                        arcTo.setLargeArcFlag(false);
                                    }

                                    break;
                                default:
                                    canMove = false;
                                    break;
                            }
                            path.getElements().add(arcTo);
                        }


                        break;
                    case "down":
                        if (nextTile.getDirection().equals("vertical")) {
                            path.getElements().add(new LineTo(100 * nextTile.getCurrentColumn() + 50, 100 * nextTile.getCurrentRow() + 100));

                        } else {
                            ArcTo arcTo = new ArcTo();
                            switch (nextTile.getDirection()) {
                                case "00":
                                    ball.setDirection("left");
                                    arcTo.setX(nextTile.getCurrentColumn() * 100);
                                    arcTo.setY(nextTile.getCurrentRow() * 100 + 50);
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(true);
                                    arcTo.setLargeArcFlag(false);

                                    break;

                                case "01":
                                    ball.setDirection("right");
                                    arcTo.setX(nextTile.getCurrentColumn() * 100 + 100);
                                    arcTo.setY(nextTile.getCurrentRow() * 100 + 50);
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(false);
                                    arcTo.setLargeArcFlag(false);

                                    break;
                                default:
                                    canMove = false;
                                    break;
                            }
                            path.getElements().add(arcTo);

                        }

                        break;
                    case "right":
                        if (nextTile.getDirection().equals("horizontal")) {
                            if (nextTile instanceof EndTile)
                                path.getElements().add(new LineTo(100 * nextTile.getCurrentColumn() + 50, 100 * nextTile.getCurrentRow() + 50));
                            else
                                path.getElements().add(new LineTo(100 * nextTile.getCurrentColumn() + 100, 100 * nextTile.getCurrentRow() + 50));

                        } else {
                            ArcTo arcTo = new ArcTo();
                            switch (nextTile.getDirection()) {
                                case "00":
                                    ball.setDirection("up");
                                    arcTo.setX(nextTile.getCurrentColumn() * 100 + 50);
                                    arcTo.setY(nextTile.getCurrentRow() * 100);
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(false);
                                    arcTo.setLargeArcFlag(false);

                                    break;

                                case "10":
                                    ball.setDirection("down");
                                    arcTo.setX(nextTile.getCurrentColumn() * 100 + 50);
                                    arcTo.setY(nextTile.getCurrentRow() * 100 + 100);
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(true);
                                    arcTo.setLargeArcFlag(false);

                                    break;
                                default:
                                    canMove = false;
                                    break;
                            }
                            path.getElements().add(arcTo);
                        }

                        break;
                    case "left":
                        if (nextTile.getDirection().equals("horizontal")) {
                            path.getElements().add(new LineTo(100 * nextTile.getCurrentColumn(), 100 * nextTile.getCurrentRow() + 50));
                        } else {
                            ArcTo arcTo = new ArcTo();
                            switch (nextTile.getDirection()) {
                                case "01":
                                    ball.setDirection("up");
                                    arcTo.setX(nextTile.getCurrentColumn() * 100 + 50);
                                    arcTo.setY(nextTile.getCurrentRow() * 100);
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(true);
                                    arcTo.setLargeArcFlag(false);

                                    break;

                                case "11":
                                    ball.setDirection("down");
                                    arcTo.setX(nextTile.getCurrentColumn() * 100 + 50);
                                    arcTo.setY(nextTile.getCurrentRow() * 100 + 100);
                                    arcTo.setXAxisRotation(50);
                                    arcTo.setRadiusX(50);
                                    arcTo.setRadiusY(50);
                                    arcTo.setSweepFlag(false);
                                    arcTo.setLargeArcFlag(false);

                                    break;
                                default:
                                    canMove = false;
                                    break;
                            }
                            path.getElements().add(arcTo);
                        }
                        break;
                }
                System.out.println(currentTile.getCurrentRow()+" "+currentTile.getCurrentColumn()+" drawed " +currentTile.getClass());

                if (nextTile instanceof EndTile){

                    ball.toFront();
                    canMove = false;
                    System.out.println("finish");
                    PathTransition pathTransition = new PathTransition();
                    pathTransition.setPath(path);
                    pathTransition.setNode(ball);
                    pathTransition.setDuration(Duration.millis(1000));
                    pathTransition.play();
                    levelSolved = true;
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
                    translate.setOnFinished(event ->{
                        isMoving=false;
                        makeLine();
                    } );
                    numberOfMoves++;

                    changedTile.setCurrentRow(tempRow);
                    changedTile.setCurrentColumn(tempColumn);


                }
            }









    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public static boolean isIsMoving() {
        return isMoving;
    }

    public static void setIsMoving(boolean isMoving) {
        GamePane.isMoving = isMoving;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
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

    public int getSpacing() {
        return spacing;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public boolean isLevelSolved() {
        return levelSolved;
    }

    public void setLevelSolved(boolean levelSolved) {
        this.levelSolved = levelSolved;
    }
}
