import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class GameScene extends Application {

    public static void main(String[] args){
        launch(args);
    }



    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Ball Pipe Maze");

        BorderPane borderPane = new BorderPane();
        StackPane pane = new StackPane();
        GamePane gamePane = new GamePane(4,4,50,10);
        pane.getChildren().add(gamePane);
        gamePane.setPadding(new Insets(10,10,10,10));


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                TestTile rectangle = new TestTile(0,0,50,50);
                rectangle.setFill(Color.color(new Random().nextDouble(),new Random().nextDouble(),new Random().nextDouble()));


                rectangle.setOnMousePressed(e->{
                    rectangle.startX= e.getX();
                    rectangle.startY = e.getY();
                });
                rectangle.setOnMouseReleased(e->{
                    rectangle.finishX=e.getX();
                    rectangle.finishY =e.getY();
                    gamePane.changeTiles(rectangle, rectangle.checkDirection());

                });



                gamePane.add(rectangle);

            }
        }

        borderPane.setCenter(pane);


        borderPane.setBottom(new Button("click me"));

        borderPane.setLeft(new Button("click me"));

        borderPane.setRight(new Button("click me"));

        borderPane.setTop(new Button("click me"));





        Scene scene = new Scene(borderPane,450  ,350);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
