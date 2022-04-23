import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameScene extends Application {

    public static void main(String[] args){
        launch(args);
    }



    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Ball Pipe Maze");


        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();



        //pane.getChildren().add(new Button("click me"));

        borderPane.setCenter(pane);


        borderPane.setBottom(new Button("click me"));

        borderPane.setLeft(new Button("click me"));
        ((Button) borderPane.getLeft()).setAlignment(Pos.CENTER);
        borderPane.setRight(new Button("click me"));
        ((Button) borderPane.getRight()).setAlignment(Pos.CENTER);
        borderPane.setTop(new Button("click me"));
        ((Button) borderPane.getTop()).setAlignment(Pos.CENTER);




        Scene scene = new Scene(borderPane,300 ,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
