package com.example.snake.Bane;

import com.example.snake.Fil;
import javafx.scene.layout.Pane;

public class BanePane extends Pane {
    private int [][] bane = Fil.hentBane("bane1.csv");

    public BanePane(){
        for (int i = 0; i <bane.length; i++) {
            for (int j = 0; j <bane[i].length ; j++) {
                getChildren().add(new Vegg(j*Vegg.WIDTH, i*Vegg.HEIGHT, bane[i][j]));
            }
        }
    }
}
