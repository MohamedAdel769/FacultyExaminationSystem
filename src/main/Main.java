package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage window ;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage ;
        Parent root = FXMLLoader.load(getClass().getResource("GUI/Login.fxml"));
        Scene scene = new Scene(root) ;
        window.setTitle("Faculty Examination System");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
