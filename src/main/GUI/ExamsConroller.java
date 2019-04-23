package main.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ExamsConroller implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    public JFXTextField CourseId,durationTime,ReleaseData,InstructorId,TotalGrade,HandlingTimer,AcceptedTimer,AcceptedStatus,id;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guiHelper.ValidateText(id, "Enter Id", false);
        guiHelper.ValidateText(CourseId, "Enter CourseId", false);
        guiHelper.ValidateText(durationTime, "Enter durationTime", false);
        guiHelper.ValidateText(ReleaseData, "Enter ReleaseData" , false);
        guiHelper.ValidateText(InstructorId, "Enter InstructorId" , false);
        guiHelper.ValidateText(TotalGrade, "Enter TotalGrade", false);
        guiHelper.ValidateText(HandlingTimer, "Enter HandlingTimer", false);
        guiHelper.ValidateText(AcceptedTimer, "Enter AcceptedTimer" , false);
        guiHelper.ValidateText(AcceptedStatus, "Enter AcceptedStatus" , false);
    }
    @FXML
    public void addExam(){
        id.clear();
        CourseId.clear();
        durationTime.clear();
        ReleaseData.clear();
        InstructorId.clear();
        TotalGrade.clear();
        HandlingTimer.clear();
        AcceptedTimer.clear();
        AcceptedStatus.clear();
    }

}
