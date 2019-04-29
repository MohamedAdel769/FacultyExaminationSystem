package main.GUI;

import java.awt.*;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import main.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import main.dataBaseHelper.DBInstructor;
import main.dataBaseHelper.DBStudent;

import javax.swing.*;

public class SignupController implements Initializable {
    private GUIHelper guiHelper = new GUIHelper() ;
    @FXML
    private JFXComboBox<String> ComboBox ;
    @FXML
    private JFXTextField AgeTxt , IDTxt, UsernameTxt, EmailTxt, PhoneTxt, FnameTxt, LnameTxt;
    @FXML
    private JFXButton SignupBtn;
    @FXML
    private JFXPasswordField PassTxt , CpassTxt;

    ObservableList<String> list = FXCollections.observableArrayList("Student", "Instructor");

    public void ComboChanged(ActionEvent event) {
        if(ComboBox.getValue().equals("Student")) {
            AgeTxt.setPromptText("Age (Instructor only)");
            AgeTxt.setEditable(false);
            AgeTxt.setText("");
            IDTxt.setEditable(true);
        }
        else {
            AgeTxt.setEditable(true);
            IDTxt.setPromptText("ID (Students only)");
            IDTxt.setEditable(false);
            IDTxt.setText("");
        }
        guiHelper.ValidateText(IDTxt, "Enter ID",false);
        guiHelper.ValidateText(AgeTxt, "Enter Age",false);
        guiHelper.ValidateText(AgeTxt, "Enter numbers only",true);
    }

    @FXML
    public void GoToLogin(ActionEvent event) {
        if(ComboBox.getValue().equals("Student")) {
            if(new DBStudent().getByUsername(UsernameTxt.getText()).Username != null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Username Handling");
                alert.setHeaderText("This Username is used:");
                alert.setContentText("Please Change your Username");
                alert.showAndWait();
            }

            else {
                DBStudent stu = new DBStudent(IDTxt.getText(), FnameTxt.getText() + " " + LnameTxt.getText(), PhoneTxt.getText(), EmailTxt.getText(), UsernameTxt.getText(), PassTxt.getText());
                stu.add(stu);
                guiHelper.GoToForm("Login.fxml");
            }

        }
        else {
            if(new DBInstructor().getByUsername(UsernameTxt.getText()).Username != null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Username Handling");
                alert.setHeaderText("This Username is used.");
                alert.setContentText("Please Change your Username.");
                alert.showAndWait();
            }
            else{
                DBInstructor inst = new DBInstructor(FnameTxt.getText() + " " + LnameTxt.getText(), PhoneTxt.getText(), EmailTxt.getText(), AgeTxt.getText(), UsernameTxt.getText(), PassTxt.getText());
                inst.add(inst);
                guiHelper.GoToForm("Login.fxml");
            }
        }
       // guiHelper.GoToForm("Login.fxml");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ComboBox.setItems(list);
        ComboBox.setValue("Student");
        AgeTxt.setEditable(false);
        IDTxt.setEditable(true);

        guiHelper.ValidateText(UsernameTxt, "Enter Username",false);
        guiHelper.ValidateText(EmailTxt, "Enter Email",false);
        guiHelper.ValidateText(FnameTxt, "Enter First Name",false);
        guiHelper.ValidateText(LnameTxt, "Enter Last Name",false);
        guiHelper.ValidateText(PhoneTxt, "Enter Mobile number",false);
        guiHelper.ValidateText(PhoneTxt, "Enter numbers only",true);
        guiHelper.ValidateText(AgeTxt, "Enter Age",false);
        guiHelper.ValidateText(AgeTxt, "Enter numbers only",true);
        guiHelper.ValidateText(IDTxt, "Enter ID",false);
        guiHelper.ValidateText(PassTxt, "Enter Password");
        guiHelper.ValidateText(CpassTxt, "Confirm Your Password");
    }
}
