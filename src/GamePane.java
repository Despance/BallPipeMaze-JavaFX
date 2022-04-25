import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class GamePane extends Pane {

    int rowCount;
    int columnCount;
    int cellSize;

    int currentRow;
    int currentColumn;
    int spacing;


    GamePane(int rowCount,int columnCount,int cellSize,int spacing){
        this.rowCount = rowCount;
        this.columnCount=columnCount;
        this.cellSize=cellSize;
        this.spacing = spacing;
    }



    public void add(TestTile e){
        super.getChildren().add(e);
        e.resize(cellSize,cellSize);
        //e.relocate(currentRow*(cellSize+spacing),currentColumn*(cellSize+spacing));
        e.setTranslateX(currentRow*(cellSize+spacing));
        e.setTranslateY(currentColumn*(cellSize+spacing));

        e.currentRow=currentRow;
        e.currentColumn=currentColumn;

        System.out.println(currentRow+ " "+ currentColumn);

        currentRow++;
        if(currentRow==rowCount){
            currentRow=0;
            currentColumn++;
        }

    }

    public void changeTiles(TestTile t,String d){

            int tempRow = t.currentRow;
            int tempColumn = t.currentColumn;


            TestTile changedTile = null;
            for(Node tile : getChildren()){
                TestTile currentTile = null;
                if (tile instanceof TestTile)
                    currentTile = (TestTile) tile;
                if(currentTile!=null){
                    switch (d){
                        case "Up":
                            if(currentTile.currentColumn==tempColumn-1 && currentTile.currentRow ==tempRow)
                                changedTile=currentTile;
                            break;
                        case "Down":
                            if(currentTile.currentColumn==tempColumn+1 && currentTile.currentRow ==tempRow)
                                changedTile=currentTile;
                            break;
                        case "Right":
                            if(currentTile.currentColumn==tempColumn && currentTile.currentRow ==tempRow+1)
                                changedTile=currentTile;
                            break;
                        case "Left":
                            if(currentTile.currentColumn==tempColumn && currentTile.currentRow ==tempRow-1)
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

                TranslateTransition translate = new TranslateTransition();
                translate.setToX(tX);
                translate.setToY(tY);
                translate.setNode(t);
                translate.setDuration(Duration.millis(500));
                translate.play();

                t.currentRow= changedTile.currentRow;
                t.currentColumn= changedTile.currentColumn;


                TranslateTransition translateB = new TranslateTransition();
                translateB.setToX(tempX);
                translateB.setToY(tempY);
                translateB.setNode(changedTile);
                translateB.setDuration(Duration.millis(500));
                translateB.play();

                changedTile.currentRow=tempRow;
                changedTile.currentColumn=tempColumn;

            }








    }



}
