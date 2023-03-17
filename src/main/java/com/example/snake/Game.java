package com.example.snake;
import Player.Player1;
import com.example.snake.Bane.BanePane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.BoundingBox;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;

import static javafx.scene.input.KeyCode.X;

public class Game extends HelloApplication {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    boolean running = false;
    boolean Timer = false;

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



    /* public void sjekkKollisjon() {
        // sjekker om hode kolliderer med kroppen
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        // sjekker om treffer venstre kant
        if (x[0] < 0) {
            running = false;
        }
        // sjekker om hode berører høyre kant
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        // sjekker om hode berører toppkant
        if (y[0] < 0) {
            running = false;
        }
        // sjekker om hode berører nederstekant
        if (x[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            Timer = false;
        }
    } */


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