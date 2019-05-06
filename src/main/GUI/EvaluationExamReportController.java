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
import javafx.util.Pair;
import main.dataBaseHelper.DBExam;
import main.dataBaseHelper.DBQustion;


import java.net.URL;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Vector;

import static java.lang.Integer.min;

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




    // zabat el vector bta3 el questions 3shan azbot el ouput
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
            // el accept status bt5osh 3la tool
            Vector<DBQustion> questions = new DBQustion().getByExamId(examID);
            Vector <Pair<String, DBQustion >> v = null;
            for(int i = 0 ; i < questions.size() ; i++){
                Pair p = new Pair(questions.elementAt(i).EvaluationRankAChar, questions.elementAt(i));
                v.add(p);
            }
            for(int i = 0 ; i < questions.size() ; i++){
                for(int j = i + 1 ; j < questions.size() ; j++){
                    Pair p1 = v.elementAt(i);
                    Pair p2 = v.elementAt(j);
                    String s1 = (String) p1.getKey();
                    String s2 = (String) p2.getKey();
                    if (s1.equals("D") && (s2.equals("A") || s2.equals("B") || s2.equals("C"))){
                        Pair p  = p1;
                        p1 = p2;
                        p2 = p;
                    }
                    if (s1.equals("C") && (s2.equals("A") || s2.equals("B") || s2.equals("C"))){
                        Pair p  = p1;
                        p1 = p2;
                        p2 = p;
                    }
                    if (s1.equals("B") && (s2.equals("A") || s2.equals("B") )){
                        Pair p  = p1;
                        p1 = p2;
                        p2 = p;
                    }


                }
            }
            displayHisto.setDisable(false);
            tabPane.setDisable(false);
            // han-fill el data hena
            Vector < String > ev = null;
            Vector < Integer > gr = null;
            for(int i = 0 ; i < min((int)v.size(),5) ; i++){
                Pair p = v.elementAt(i);
                DBQustion temp = (DBQustion) p.getValue();
                ev.add(temp.EvaluationRankAChar);
                gr.add(temp.grade);
            }
            q1_gradeBox.setText(gr.elementAt(0).toString());
            q1_evaluationRankBox.setText(ev.elementAt(0));
            q2_gradeBox.setText(gr.elementAt(1).toString());
            q2_evaluationRankBox.setText(ev.elementAt(1));
            q3_gradeBox.setText(gr.elementAt(2).toString());
            q3_evaluationRankBox.setText(ev.elementAt(2));
            q4_gradeBox.setText(gr.elementAt(3).toString());
            q4_evaluationRankBox.setText(ev.elementAt(3));
            q5_gradeBox.setText(gr.elementAt(4).toString());
            q5_evaluationRankBox.setText(ev.elementAt(4));
        }
        else {
            guiHelper.ShowDialog(h5a,"Error","This exam status still open","OK");
        }
        /// dool elmafrood hna wla t7t
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
