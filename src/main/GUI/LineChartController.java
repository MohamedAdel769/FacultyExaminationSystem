package main.GUI;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.util.Pair;
import main.dataBaseHelper.DBQustion;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LineChartController {
    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    void backToHistoButton(ActionEvent event) {
        new GUIHelper().GoToForm("Histogram.fxml");
    }
    public void initialize(URL url, ResourceBundle resourceBundle){
        ArrayList <Pair< Integer, DBQustion >> v = passData.QuestionsFreq;
        XYChart.Series series = new XYChart.Series();
        for(int i = 0 ; i < v.size() ; i++){
            String questionID = v.get(i).getValue().QuesID;
            int num = (int)v.get(i).getKey();
            series.getData().add(new XYChart.Data(questionID, num));
        }
        lineChart.getData().addAll(series);
    }


}
