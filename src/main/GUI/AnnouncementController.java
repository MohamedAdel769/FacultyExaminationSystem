package main.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Pair;
import main.dataBaseHelper.DBAnnouncement;

import java.net.URL;
import java.util.ResourceBundle;

public class AnnouncementController implements Initializable {

    @FXML
    private Label instName;

    @FXML
    private JFXTextField examIDTxt;

    @FXML
    private JFXTextArea bodyTxt;

    @FXML
    private JFXTextField headerTxt;

    @FXML
    private JFXButton addBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instName.setText(passData.instructor.Name);
    }

    @FXML
    public void Add(ActionEvent event){
        DBAnnouncement announcement = new DBAnnouncement(GUIHelper.randomAlphaNumeric(4),passData.instructor.Username, examIDTxt.getText(), bodyTxt.getText(), headerTxt.getText());
        new DBAnnouncement().add(announcement);
        examIDTxt.clear();
        bodyTxt.clear();
        headerTxt.clear();
    }
}
