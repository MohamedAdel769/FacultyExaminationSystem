package main.GUI;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class HistogramController implements Initializable {
    @FXML
    private JFXTextField histoExamID;

    @FXML
    private TableView<?> tableGamed;

    @FXML
    private TableColumn<?, ?> gradesCol;

    @FXML
    private TableColumn<?, ?> numberOfStudentsCol;

    @FXML
    void backToEvaluationButton(ActionEvent event) {
        new GUIHelper().GoToForm("EvaluationExamReport.fxml");
    }

    @FXML
    void viewHistogramButton(ActionEvent event) {
        new GUIHelper().GoToForm("LineChart.fxml");
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
