package com.example.snake;
import Player.Player1;
import com.example.snake.Bane.BanePane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Game extends HelloApplication {

    int test = 0;
    Text score = new Text("Score: "  + test);
    Text spiller1 = new Text("spiller1");

    BorderPane screen = new BorderPane();
    BanePane bane = new BanePane();

    public Game() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage) throws IOException {
         Player1 player1 = new Player1();

        Scene scene = new Scene(screen, 972, 972);
        stage.setScene(scene);
        stage.setResizable(false);

        // legger til knapper som gjør at du kan bevege spiller som er hentet fra klassen player1
         scene.setOnKeyPressed(e->player1.pressHandler(e)) ;

        // velger hvor fort eller sakte loopen oppdaterer
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), e-> Update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // legger til bilde av av de forskjellige objektene i spillet.
        // kart.getChildren().addAll(new Ghost());
        // kart.getChildren().addAll(new Ghost2());
        // kart.getChildren().addAll(new Ghost3());
        // kart.getChildren().addAll(new Ghost4());
        bane.getChildren().addAll(player1);
        // kart.getChildren().addAll(new Bigdot());
        // kart.getChildren().addAll(new Bigdot2());
        // kart.getChildren().addAll(new Bigdot3());
        // kart.getChildren().addAll(new Bigdot4());

        stage.setTitle("Snake");
        stage.show();

         if((player1.getX() < 0) || (player1.getX() > 972) || (player1.getY() < 0) || (player1.getY() > 972)) {
            stage.close();
        }
    }

    // game loop
    public void Update(){
        screen.setCenter(bane);
        screen.setTop(score);
        screen.setRight(spiller1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}