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
import main.dataBaseHelper.DBInstructor;
import main.dataBaseHelper.DBStudent;

public class LoginController implements Initializable  {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    private JFXPasswordField PassTxt ;
    @FXML
    private JFXTextField textField, UserTxt ;
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
        guiHelper.GoToForm("Signup.fxml");
    }

    @FXML
    public void Signin(ActionEvent event){
        // if the user is admin
            //guiHelper.GoToForm("AdminHome.fxml");
        // student
        if (new DBStudent().getByUsername(UserTxt.getText()).Username != null) {
            if (PassTxt.getText().equals(new DBStudent().getByUsername(UserTxt.getText()).Password)) {
                guiHelper.GoToForm("Exams.fxml");
            }
        }
        else if (new DBInstructor().getByUsername(UserTxt.getText()).Username != null){
            if (PassTxt.getText().equals(new DBInstructor().getByUsername(UserTxt.getText()).Password)) {
                guiHelper.GoToForm("InstructorHome.fxml");
            }
        }


        // instructor

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField.setManaged(false);
        textField.setVisible(false);
        Image image = new Image("/imgs/hide.png");
        EyeImg.setImage(image);

        guiHelper.ValidateText(UserTxt, "Enter Username", false);
        guiHelper.ValidateText(textField, "Enter Password", false);
        guiHelper.ValidateText(PassTxt, "Enter Password");
    }
}
