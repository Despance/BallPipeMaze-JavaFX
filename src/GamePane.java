import javafx.scene.Node;
import javafx.scene.layout.Pane;

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
        e.relocate(currentRow*(cellSize+spacing),currentColumn*(cellSize+spacing));

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

            int a =0;
            int b =0;

            double tempX = t.getLayoutX();
            double tempY = t.getLayoutY();

            int tempRow = t.currentRow;
            int tempColumn = t.currentColumn;

            switch (d){
                case "Up":
                    b =-1;
                    break;
                case "Down":
                    b = +1;
                    break;
                case "Right":
                    a = +1;
                    break;
                case "Left":
                    a = -1;
                    break;
            }


            //for ile ara

            TestTile changedTile = (TestTile) getChildren().get(tempRow+a+((tempColumn+b)*columnCount));

            System.out.println("startTile "+tempRow+" "+tempColumn);
        System.out.println("changedTile "+changedTile.currentRow+" "+ changedTile.currentColumn);
            t.relocate(changedTile.getLayoutX(),changedTile.getLayoutY());
            t.currentRow= changedTile.currentRow;
            t.currentColumn= changedTile.currentColumn;

            changedTile.relocate(tempX,tempY);
            changedTile.currentRow=tempRow;
            changedTile.currentColumn=tempColumn;






    }



}
