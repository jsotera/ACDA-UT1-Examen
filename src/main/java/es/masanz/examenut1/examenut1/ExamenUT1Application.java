package es.masanz.examenut1.examenut1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExamenUT1Application extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExamenUT1Application.class.getResource("window-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 440);
        stage.setTitle("Examen UT1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}