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


import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

import static java.lang.Integer.min;


public class EvaluationExamReportController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    private JFXTextField idExamBox;

    @FXML
    private JFXButton displayHisto;

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private JFXTextArea z1;

    @FXML
    private Label q1_gradeBox;

    @FXML
    private Label q1_evaluationRankBox;

    @FXML
    private JFXTextArea z2;

    @FXML
    private Label q2_gradeBox;

    @FXML
    private Label q2_evaluationRankBox;

    @FXML
    private JFXTextArea z3;

    @FXML
    private Label q3_gradeBox;

    @FXML
    private Label q3_evaluationRankBox;

    @FXML
    private JFXTextArea z4;

    @FXML
    private Label q4_gradeBox;

    @FXML
    private Label q4_evaluationRankBox;

    @FXML
    private JFXTextArea z5;

    @FXML
    private Label q5_gradeBox;

    @FXML
    private Label q5_evaluationRankBox;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawersStack Drawer;

    @FXML
    private StackPane h5a;

    @FXML
    private VBox vBox;



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
    public void Search(ActionEvent event){
        // if we have this exam id and duration is finished then
        String studentID = passData.Student.stdID;
        String examID = idExamBox.getText();
        DBExam curExam = new DBExam().getById(examID);
        passData.examID = examID;
        if (curExam.acceptStatus == false){
            ArrayList < DBQustion > v = new ArrayList<>();
            ArrayList< Pair<Integer, DBQustion>> questions = new DBQustion().getHis(examID);
            for(int i = 0 ; i < questions.size() ; i++){
                System.out.println(questions.get(i).getValue().Question);
            }
            for(int i = 0 ; i < 5 ; i++){
                for(int j = i + 1 ; j < questions.size() ; j++){
                    Pair p1 = questions.get(i);
                    Pair p2 = questions.get(j);
                    if((int)p1.getKey() > (int)p2.getKey()){
                        Pair < Integer, DBQustion > temp;
                        temp = p1;
                        questions.set(i, questions.get(j));
                        questions.set(j, temp);
                    }
                }
                DBQustion z = questions.get(i).getValue();
                v.add(z);
            }
            displayHisto.setDisable(false);
            tabPane.setDisable(false);
            // han-fill el data hena
            ArrayList < String > ev =new ArrayList<>();
            ArrayList < Integer > gr = new ArrayList<>();
            ArrayList < String > txt = new ArrayList<>();
            for(int i = 0 ; i < 5 ; i++){
                DBQustion he5o = v.get(i);
                ev.add(he5o.EvaluationRankAChar);
                gr.add(he5o.grade);
                txt.add(he5o.Question);
            }
            q1_gradeBox.setText(gr.get(0).toString());
            q1_evaluationRankBox.setText(ev.get(0));
            z1.setText(txt.get(0));
            q2_gradeBox.setText(gr.get(1).toString());
            q2_evaluationRankBox.setText(ev.get(1));
            z2.setText(txt.get(1));
            q3_gradeBox.setText(gr.get(2).toString());
            q3_evaluationRankBox.setText(ev.get(2));
            z3.setText(txt.get(2));
            q4_gradeBox.setText(gr.get(3).toString());
            q4_evaluationRankBox.setText(ev.get(3));
            z4.setText(txt.get(3));
            q5_gradeBox.setText(gr.get(4).toString());
            q5_evaluationRankBox.setText(ev.get(4));
            z5.setText(txt.get(4));
            tabPane.setDisable(false);
            displayHisto.setDisable(false);
        }
        else {
            guiHelper.ShowDialog(h5a,"Error","This exam status still open","OK","-1");
        }
        /// dool elmafrood hna wla t7t
    }


    public void displayHistogram(ActionEvent event){
          passData.examID = idExamBox.getText();
          guiHelper.GoToForm("Histogram.fxml");
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
