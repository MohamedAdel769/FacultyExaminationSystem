package main.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
            AgeTxt.setDisable(true);
            AgeTxt.setText("");
            IDTxt.setDisable(false);
        }
        else {
            AgeTxt.setDisable(false);
            IDTxt.setPromptText("ID (Students only)");
            IDTxt.setText("");
            IDTxt.setDisable(true);
        }
        guiHelper.ValidateText(IDTxt, "Enter ID",false);
        guiHelper.ValidateText(AgeTxt, "Enter Age",false);
        guiHelper.ValidateText(AgeTxt, "Enter numbers only",true);
    }

    @FXML
    public void GoToLogin(ActionEvent event) {
        guiHelper.GoToForm("Login.fxml");
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
