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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;
import main.dataBaseHelper.DBExam;
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
    private TableColumn<tableData, String> gradesCol = new TableColumn<>("Qeustion ID");

    @FXML
    private TableColumn<tableData, String> numberOfStudentsCol = new TableColumn<>("Number of students ");

    @FXML
    void backToEvaluationButton(ActionEvent event) {
        new GUIHelper().GoToForm("EvaluationExamReport.fxml");
    }

    @FXML
    void viewHistogramButton(ActionEvent event) {
        passData.Question_num = new DBQustion().getHis(passData.examID);
        new GUIHelper().GoToForm("LineChart.fxml");
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gradesCol.setCellValueFactory(new PropertyValueFactory("fff"));
        numberOfStudentsCol.setCellValueFactory(new PropertyValueFactory("sss"));
        ArrayList <Pair<Integer, DBQustion>> v = new DBQustion().getHis(passData.examID);
        ObservableList< tableData > print = FXCollections.observableArrayList();
        int totalStudents = (int)new DBExam().getById(passData.examID).num;
        for(int i = 0 ; i < v.size() ; i++){
            tableData temp = new tableData();
            temp.fff = new SimpleStringProperty(v.get(i).getValue().QuesID);
            double ratio = 5 ;
            ratio = v.get(i).getKey() / Math.max(totalStudents, 1);
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
