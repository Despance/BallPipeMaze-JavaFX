import Tiles.FreeTile;
import Tiles.Movable;
import Tiles.Tile;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GamePane extends Pane {

    private static boolean isMoving = false;

    int rowCount;
    int columnCount;
    int cellSize;

    int currentRow;
    int currentColumn;
    int spacing;


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

    public void changeTiles(Tile t,String d){


            if (!isMoving && t instanceof Movable && !(t instanceof FreeTile)){

                int tempRow = t.getCurrentRow();
                int tempColumn = t.getCurrentColumn();


                Tile changedTile = null;
                for(Node tile : getChildren()){
                    Tile currentTile = null;
                    if (tile instanceof FreeTile)
                        currentTile = (Tile) tile;

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
