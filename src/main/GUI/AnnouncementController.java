package main.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

    }

    @FXML
    public void Add(ActionEvent event){
        //examID, msgBody,  msgHead, tableName, tableId
        //DBAnnouncement announcement = new DBAnnouncement(passData.instructor.Username, examIDTxt.getText(), );
    }
}
