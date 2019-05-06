package main.GUI;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.mysql.cj.x.protobuf.Mysqlx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.dataBaseHelper.DBExam;

import java.net.URL;
import java.util.ResourceBundle;

public class EvaluationExamReportController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    JFXTabPane tabPane ;
    @FXML
    JFXButton displayHisto ;
    @FXML
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;
    // Bohoty
    @FXML
    JFXTextField idExamBox;
    @FXML
    StackPane h5a;
    @FXML
    Label q1_gradeBox ;
    @FXML
    Label q1_evaluationRankBox;
    @FXML
    Label q2_gradeBox ;
    @FXML
    Label q2_evaluationRankBox;
    @FXML
    Label q3_gradeBox ;
    @FXML
    Label q3_evaluationRankBox;
    @FXML
    Label q4_gradeBox ;
    @FXML
    Label q4_evaluationRankBox;
    @FXML
    Label q5_gradeBox ;
    @FXML
    Label q5_evaluationRankBox;
    // Bohoty

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
    public void Search(ActionEvent e){
        // if we have this exam id and duration is finished then
        String studentID = passData.Student.stdID;
        String examID = idExamBox.getText();
        DBExam curExam = new DBExam().getById(examID);
        if (curExam.acceptStatus == false){
            displayHisto.setDisable(false);
            tabPane.setDisable(false);
            // han-fill el data hena
        }
        else {
            guiHelper.ShowDialog(h5a,"Error","This exam status still open","OK");
        }
        tabPane.setDisable(false);
        displayHisto.setDisable(false);
    }
    public void displayHistogram(ActionEvent e){

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
