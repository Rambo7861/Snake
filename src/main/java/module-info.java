module com.example.snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snake to javafx.fxml;
    exports com.example.snake;
    exports com.example.snake.Bane;
    opens com.example.snake.Bane to javafx.fxml;
}