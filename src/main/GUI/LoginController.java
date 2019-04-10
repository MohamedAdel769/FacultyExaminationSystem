package main.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;

public class LoginController implements Initializable  {
    @FXML
    private JFXPasswordField PassTxt ;
    @FXML
    private JFXTextField textField ;
    @FXML
    private JFXToggleButton ToggleBtn ;
    @FXML
    private ImageView EyeImg ;

    @FXML
    public void ShowPass(ActionEvent event) {
        textField.managedProperty().bind(ToggleBtn.selectedProperty());
        textField.visibleProperty().bind(ToggleBtn.selectedProperty());

        PassTxt.managedProperty().bind(ToggleBtn.selectedProperty().not());
        PassTxt.visibleProperty().bind(ToggleBtn.selectedProperty().not());

        textField.textProperty().bindBidirectional(PassTxt.textProperty());

        if(!ToggleBtn.isSelected()) {
            Image image = new Image("/imgs/hide.png");
            EyeImg.setImage(image);
        }
        else {
            Image image = new Image("/imgs/view.png");
            EyeImg.setImage(image);
        }
    }

    @FXML
    public void GoToSignup(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
            Scene scene = new Scene(root);
            Main.window.setScene(scene);
            Main.window.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Signin(ActionEvent event){
        // if the user is admin
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
            Scene scene = new Scene(root);
            Main.window.setScene(scene);
            Main.window.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
        // student

        // instructor
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField.setManaged(false);
        textField.setVisible(false);
        Image image = new Image("/imgs/hide.png");
        EyeImg.setImage(image);
    }
}
