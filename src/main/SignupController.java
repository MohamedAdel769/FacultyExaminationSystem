package main;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SignupController implements Initializable {
    @FXML
    private JFXComboBox<String> ComboBox ;
    @FXML
    private JFXTextField AgeTxt , IDTxt, UsernameTxt;
    @FXML
    private JFXButton SignupBtn;

    ObservableList<String> list = FXCollections.observableArrayList("Student", "Instructor");

    public void ComboChanged(ActionEvent event) {
        if(ComboBox.getValue().equals("Student")) {
            AgeTxt.setEditable(false);
            IDTxt.setEditable(true);
        }
        else {
            AgeTxt.setEditable(true);
            IDTxt.setEditable(false);
        }
    }

    @FXML
    public void GoToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            Main.window.setScene(scene);
            Main.window.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ComboBox.setItems(list);
        ComboBox.setValue("Student");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                UsernameTxt.requestFocus();
            }
        });
    }
}
