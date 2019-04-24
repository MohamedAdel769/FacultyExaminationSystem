package main.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EvaluationExamReportController implements Initializable {
    @FXML
    JFXTabPane tabPane ;
    @FXML
    JFXButton displayHisto ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void Search(ActionEvent e){
        // if we have this exam id and duration is finished then

        tabPane.setDisable(false);
        displayHisto.setDisable(false);
    }
}
