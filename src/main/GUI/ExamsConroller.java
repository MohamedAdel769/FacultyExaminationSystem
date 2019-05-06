package main.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.dataBaseHelper.DBExam;
import main.dataBaseHelper.dataBaseConVars;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ExamsConroller implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    JFXTextField CourseId,durationTime,TotalGrade,id;
    @FXML
    JFXTimePicker HandlingTimer, ReleaseTime ;
    @FXML
    JFXDatePicker ReleaseDate ;

    @FXML
    public void addExam(){
        String idValue = id.getText();
        String CourseIdValue = CourseId.getText();
        String durationTimeValue = durationTime.getText();
        int TotalGradeValue = Integer.parseInt(TotalGrade.getText());
        String HandlingTimerValue = HandlingTimer.getValue().format(DateTimeFormatter.ISO_TIME);
        String ReleaseDateValue = ReleaseDate.getValue().format(DateTimeFormatter.ISO_DATE);
        String ReleaseTimeValue = ReleaseTime.getValue().format(DateTimeFormatter.ISO_TIME);
        String instrID = passData.instructor.Username;
        passData.Exam = new DBExam(idValue , CourseIdValue , durationTimeValue , true , ReleaseDateValue , instrID,
                TotalGradeValue ,HandlingTimerValue ,ReleaseTimeValue );
        if(new DBExam().add(passData.Exam) != dataBaseConVars.OK){
            System.out.println("not Added");
        }else {
            id.clear();
            CourseId.clear();
            durationTime.clear();
            TotalGrade.clear();
            new GUIHelper().GoToForm("Questions.fxml");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guiHelper.ValidateText(id, "Enter Id", false);
        guiHelper.ValidateText(CourseId, "Enter CourseId", false);
        guiHelper.ValidateText(durationTime, "Enter durationTime", false);
        guiHelper.ValidateText(TotalGrade, "Enter TotalGrade", false);
    }
}
