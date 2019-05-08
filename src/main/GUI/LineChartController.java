package main.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.util.Pair;
import main.Exam.Exam;
import main.dataBaseHelper.DBQustion;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LineChartController implements Initializable{
    @FXML
    private LineChart<String, Integer> lineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    void backButton(ActionEvent event) {
        new GUIHelper().GoToForm("Histogram.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ArrayList <Pair< Integer, DBQustion >> v = passData.Question_num;
        XYChart.Series series = new XYChart.Series();
        System.out.println(v.size());
        for(int i = 0 ; i < v.size() ; i++){
            String questionID = v.get(i).getValue().QuesID;
            int num = v.get(i).getKey();
            series.getData().add(new XYChart.Data(questionID, num));
        }
        lineChart.getData().addAll(series);
    }


}
