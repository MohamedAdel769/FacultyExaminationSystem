package main.GUI;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Pair;
import main.dataBaseHelper.DBQustion;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HistogramController implements Initializable {
    @FXML
    private JFXTextField histoExamID;

    @FXML
    private TableView<tableData> tableGamed;

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
        ExamController e = new ExamController() ;
        ArrayList <Pair<Integer, DBQustion>> v = e.getFreq(passData.examID);
        ObservableList< tableData > print = FXCollections.observableArrayList();
        /// 7ot dola hena
        int totalStudents = 5;
        for(int i = 0 ; i < v.size() ; i++){
            tableData temp = new tableData();
            temp.fff = new SimpleStringProperty(v.get(i).getValue().QuesID);
            double ratio ;
            ratio = v.get(i).getKey() / totalStudents;
            String he5o ;
            if (ratio >= 50){
                he5o = "Experienced";
            }
            else
                he5o = "Wrong";
            temp.sss = new SimpleStringProperty(he5o);
            print.add(temp);
        }
        tableGamed.setItems(print);
    }
}
