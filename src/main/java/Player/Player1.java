package Player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Player1 extends ImageView {
    int posX = 15;
    int posY = 15;

    Image player1Image = new Image(new FileInputStream("C:\\Users\\sair7\\IdeaProjects\\Snake\\src\\main\\resources\\Images\\Player1.png"));

    public Player1() throws FileNotFoundException {
        this.setImage(player1Image);
        this.setX(300);
        this.setY(905);
        this.setFitHeight(25);
        this.setFitWidth(25);
    }

    public void pressHandler(KeyEvent e) {
        switch (e.getCode()){
            case UP -> this.setY(this.getY()-10);
            case DOWN -> this.setY(this.getY()+10);
            case LEFT -> this.setX(this.getX()-10);
            case RIGHT -> this.setX(this.getX()+10);
        }
    }
}