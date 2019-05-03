package main.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ExamsConroller implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    JFXTextField CourseId,durationTime,TotalGrade,id;
    @FXML
    JFXTimePicker HandlingTimer, ReleaseTime ;
    @FXML
    JFXDatePicker ReleaseDate ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guiHelper.ValidateText(id, "Enter Id", false);
        guiHelper.ValidateText(CourseId, "Enter CourseId", false);
        guiHelper.ValidateText(durationTime, "Enter durationTime", false);
        guiHelper.ValidateText(TotalGrade, "Enter TotalGrade", false);
        HandlingTimer.activeValidatorProperty();
        ReleaseDate.activeValidatorProperty();
        ReleaseTime.activeValidatorProperty();
    }
    @FXML
    public void addExam(){
        id.clear();
        CourseId.clear();
        durationTime.clear();
        TotalGrade.clear();
    }

}
