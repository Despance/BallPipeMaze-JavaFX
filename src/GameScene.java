import Tiles.Tile;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;

public class GameScene extends Application {
    static File input = new File("input");
    static ArrayList<String> levelList = new ArrayList<>();

    public static void main(String[] args){
        File music = new File("assets");
        String s = "/BackgroundMusic.mp3";

        Media backgroundMusic = new Media(music.toURI() + s);
        AudioClip mediaPlayer = new AudioClip(backgroundMusic.getSource());
        mediaPlayer.setVolume(0.1);
        mediaPlayer.setCycleCount(Integer.MAX_VALUE);
        mediaPlayer.play();

        for (File file : input.listFiles()) {
            if (!file.isDirectory()) {
                levelList.add(file.getPath());
                System.out.println(file.getPath());
            }
        }

        launch(args);
    }



    Io currentLevel;
int currentLevelIndex = 0;
    GamePane gamePane;
    Scene scene;
    public static Text text;


    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Ball Pipe Maze");

        BorderPane borderPane = new BorderPane();
        StackPane pane = new StackPane();
        gamePane = new GamePane(4,4,100,0);
        pane.getChildren().add(gamePane);
        gamePane.setPadding(new Insets(10,10,10,10));





            currentLevel = new Io(new File(levelList.get(currentLevelIndex)));
            System.out.println(levelList.get(currentLevelIndex));
            currentLevel.decodeInput();
            currentLevelIndex++;

        for(Tile tile:currentLevel.getList()){
            tile.setOnMousePressed(new onMousePressedHandler(tile));
            tile.setOnMouseReleased(new onMouseReleasedHandler(tile,gamePane));
            gamePane.add(tile);
        }
        gamePane.addBall(new Ball(0,0,20));



        pane.setPadding(new Insets(10,10,10,10));
        borderPane.setCenter(pane);

        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> {
            gamePane.drawLine();
        });
        hBox.getChildren().add(checkButton);

        text = new Text("move count: " + gamePane.getNumberOfMoves());
        hBox.getChildren().add(text);



        gamePane.getPathTransition().setOnFinished(event -> {
            if (currentLevelIndex!=levelList.size()){
            if(gamePane.isLevelSolved()) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("You Won");
                alert.setHeaderText("You have completed this level using "+ gamePane.getNumberOfMoves()+" moves");
                alert.setContentText("Press next to go to the next level");

                alert.setOnHidden(event1 ->  start(primaryStage));

                ButtonType buttonNext = new ButtonType("Next");

                alert.getButtonTypes().setAll(buttonNext);

                alert.show();
            }
        }else {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText("You have completed all the levels");
                alert.setContentText("Press exit to end the game");

                alert.setOnHidden(event1 -> System.exit(0));

                ButtonType buttonNext = new ButtonType("Exit");

                alert.getButtonTypes().setAll(buttonNext);

                alert.show();
            }
        });

        Text levelText = new Text("Level " + currentLevelIndex);
        hBox.getChildren().add(levelText);

        borderPane.setBottom(hBox);


        scene = new Scene(borderPane,426  ,454);

        primaryStage.setScene(scene);
        primaryStage.show();


    }






}

class onMousePressedHandler implements EventHandler<MouseEvent> {
    Tile tile;
    onMousePressedHandler(Tile tile){
        this.tile = tile;

    }
    @Override
    public void handle(MouseEvent event) {
        tile.setStartX(event.getX());
        tile.setStartY(event.getY());
    }
}



class onMouseReleasedHandler  implements EventHandler<MouseEvent> {

    Tile tile;
    GamePane gamePane;
    onMouseReleasedHandler(Tile tile,GamePane gamePane){
        this.tile = tile;
        this.gamePane = gamePane;
    }


    @Override
    public void handle(MouseEvent event) {
        tile.setFinishX(event.getX());
        tile.setFinishY(event.getY());
        gamePane.changeTiles(tile,tile.checkDirection());

    }
}
