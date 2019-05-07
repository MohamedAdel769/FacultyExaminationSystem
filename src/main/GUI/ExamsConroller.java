package main.GUI;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
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
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;

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
        JFXDrawer leftDrawer = new JFXDrawer();
        vBox.setVisible(true);
        leftDrawer.setSidePane(vBox);
        leftDrawer.setDefaultDrawerSize(210);
        leftDrawer.setOverLayVisible(false);
        leftDrawer.setResizableOnDrag(true);

        HamburgerBackArrowBasicTransition hamTrans = new HamburgerBackArrowBasicTransition(hamburger);
        hamTrans.setRate(-1);
        Drawer.setViewOrder(-1);
        vBox.setVisible(true);
        Drawer.setVisible(true);
        hamburger.setVisible(true);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
            hamTrans.setRate(hamTrans.getRate() * -1);
            hamTrans.play();
            Drawer.toggle(leftDrawer);
            if(hamTrans.getRate() == 1)
                Drawer.setPrefWidth(185);
            else
                Drawer.setPrefWidth(55);
        });
    }
    @FXML
    public void LogOut(ActionEvent e){
        guiHelper.GoToForm("Login.fxml");
    }
    @FXML
    public void addCourses(ActionEvent e){
        guiHelper.GoToForm("Courses.fxml");
    }
    @FXML
    public void Exam(ActionEvent e){
        guiHelper.GoToForm("Exams.fxml");
    }
    @FXML
    public void ExamReport(ActionEvent e){
        guiHelper.GoToForm("EvaluationExamReport.fxml");
    }
    @FXML
    public void Home(ActionEvent e){
        guiHelper.GoToForm("instructorHome.fxml");
    }
}
