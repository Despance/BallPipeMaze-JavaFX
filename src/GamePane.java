import Tiles.*;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.util.Duration;


public class GamePane extends Pane {


    //Variables for the construct the custom pane
    private static boolean isMoving = false;

    private int rowCount;
    private int columnCount;
    private int cellSize;

    private int currentRow;
    private int currentColumn;
    private int spacing;

    private int numberOfMoves = 0;

    private boolean levelSolved = false;

    private PathTransition pathTransition = new PathTransition();
    Ball ball;


    //Game Pane constructor
    public GamePane(int rowCount,int columnCount,int cellSize,int spacing){
        this.rowCount = rowCount;
        this.columnCount=columnCount;
        this.cellSize=cellSize;
        this.spacing = spacing;
    }


    //This method adds given tile to the pane.
    public void add(Tile e){
        super.getChildren().add(e);

        //Resize the tile
        e.setFitWidth(cellSize);
        e.setFitHeight(cellSize);

        //Set the position of the tile
        e.setTranslateX(currentRow*(cellSize+spacing));
        e.setTranslateY(currentColumn*(cellSize+spacing));

        //Set the row and column values of the tile
        e.setCurrentRow(currentRow);
        e.setCurrentRow(currentColumn);

        //Informative message when initializing the tiles
        System.out.println(currentRow+ " "+ currentColumn+" "+e.getClass());

        currentRow++;
        if(currentRow==rowCount){
            currentRow=0;
            currentColumn++;
        }

    }


    //This method adds the ball to the Starter Tile
    public void addBall( Ball ball){
        this.ball = ball;
        super.getChildren().add(ball);
        ball.toFront();


        //Find the starter tile
        StarterTile starterTile = null;
        for (Node tile :getChildren()){
            if (tile instanceof StarterTile ){
                starterTile = (StarterTile) tile;
                break;
            }

        }
        //Set balls position
        if (starterTile!=null){

            ball.setTranslateX(starterTile.getTranslateX()+50);
            ball.setTranslateY(starterTile.getTranslateY()+50);
        }

    }

    //This method is to debug the line. It shows the path will be taken by the ball
    public void drawLine(){
        Path path = makeLine();

        getChildren().add(path);
        path.toFront();

    }



    public Path makeLine(){

        //Create a path
        Path path = new Path();

        boolean canMove = true;
        //Get current tile
        Tile currentTile= null;

        //Find the starter tile and draw a line according to it's type
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



        do {
            Tile nextTile = null;

            if(currentTile!= null){
            int row = currentTile.getCurrentRow();
            int column = currentTile.getCurrentColumn();

            //find the next tile's coordinates
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


            //Find the next tile
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
                //Draw the line according to next tile's type if it is suitable to transition of the ball.
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
                //Give an informative message if the line is drawn
                System.out.println(currentTile.getCurrentRow()+" "+currentTile.getCurrentColumn()+" drawed " +currentTile.getClass());

                //Finish the game if you have reached the end tile
                if (nextTile instanceof EndTile){
                    ball.toFront();
                    canMove = false;
                    System.out.println("finish");
                    pathTransition.setPath(path);
                    pathTransition.setNode(ball);
                    pathTransition.setDuration(Duration.millis(1000));
                    pathTransition.play();
                    levelSolved = true;

                }else{
                    //Our next tile will be our current tile in the next iteration of the loop.
                    currentTile = nextTile;
                }
            }else{
                //break the loop
                canMove = false;
            }
        }

        }while (canMove);

        return path;

    }


    //This method changes the given tile according to the given direction.
    public void changeTiles(Tile t,String d){
            if (!isMoving && t instanceof Movable && !(t instanceof FreeTile)){

                //Get the first tile's coordinates
                int tempRow = t.getCurrentRow();
                int tempColumn = t.getCurrentColumn();


                Tile changedTile = null;

                //Find the tile will be changed
                for(Node tile : getChildren()){
                    Tile currentTile = null;
                    if (tile instanceof FreeTile){
                        currentTile = (Tile) tile;
                    }

                    if(currentTile!=null){
                        //Calculate the tile will be found according to the direction
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
                    //Get the temp positions
                    double tempX = t.getTranslateX();
                    double tempY = t.getTranslateY();
                    double tX = changedTile.getTranslateX();
                    double tY = changedTile.getTranslateY();

                    //Animate the first tile
                    isMoving= true;
                    t.toFront();
                    TranslateTransition translate = new TranslateTransition();
                    translate.setToX(tX);
                    translate.setToY(tY);
                    translate.setNode(t);
                    translate.setDuration(Duration.millis(500));
                    translate.play();

                    //Set the first tile's coordinate with the new ones
                    t.setCurrentRow(changedTile.getCurrentRow()) ;
                    t.setCurrentColumn(changedTile.getCurrentColumn());

                    //Animate the second tile
                    TranslateTransition translateB = new TranslateTransition();
                    translateB.setToX(tempX);
                    translateB.setToY(tempY);
                    translateB.setNode(changedTile);
                    translateB.setDuration(Duration.millis(500));
                    translateB.play();

                    //Set the isMoving the false to wait animation to finish and after every move check the solution
                    translate.setOnFinished(event ->{
                        isMoving=false;
                        makeLine();

                    } );
                    //Change the move count text at the pane
                    GameScene.text.setText("move count: " + ++numberOfMoves);

                    //Set the second tile's coordinates
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

    public PathTransition getPathTransition() {
        return pathTransition;
    }

    public void setPathTransition(PathTransition pathTransition) {
        this.pathTransition = pathTransition;
    }
}
