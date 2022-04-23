import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameScene extends Application {

    public static void main(String[] args){
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane,300 ,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
