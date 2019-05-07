package main.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.WindowEvent;
import javafx.util.Pair;
import main.Exam.Question;
import main.dataBaseHelper.DBExam;
import main.dataBaseHelper.DBQustion;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import main.Main;

import javax.swing.*;


public class ExamController implements Initializable {
    ArrayList<DBQustion> Qlist ;
    DBQustion dbQ ;
    int currIndex , mxIndex ;
    @FXML
    JFXTextArea questionTxt ;
    @FXML
    JFXCheckBox choice1 ,choice2, choice3 , choice4 ;
    @FXML
    Label qNo, timeLeft ;
    @FXML
    JFXButton startBtn ;
    @FXML
    Label userName , name;
    @FXML
    StackPane stackPane ;
    @FXML
    JFXButton submitBtn, nextBtn , prevBtn ;

    public int TotalS ;
    int[] ch;
    int totalGrade  ;
    DBExam e ;
    GUIHelper g ;
    Timer timert ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       timeLeft.setText("00:00:00");
       qNo.setText("0");
       totalGrade = 0;
       dbQ  = new DBQustion();
       Qlist  = new ArrayList<>(dbQ.getByExamId("z"));
       timert = new Timer();
       mxIndex = Qlist.size() ;
       ch  = new int[mxIndex];
       for(int i = 0;i<mxIndex;i++){
           ch[i] = -1;
       }
       currIndex = 0;
       userName.setText(passData.Student.Username);
       name.setText(passData.Student.Name);
       e = new DBExam();
       g = new GUIHelper();
    }

    @FXML
    public void startTimer(ActionEvent event){
        prevBtn.setDisable(false);
        nextBtn.setDisable(false);
        submitBtn.setDisable(false);
        choice1.setDisable(false);
        choice2.setDisable(false);
        choice3.setDisable(false);
        choice4.setDisable(false);
        SetQuestion(Qlist.get(currIndex));
        qNo.setText("1");
        timeLeft.setText(e.getById("z").durationTime);
        String [] time = e.getById("z").durationTime.split(":");
        int H = Integer.parseInt(time[0]) , M = Integer.parseInt(time[1]) , S = Integer.parseInt(time[2]);
        TotalS = (M * 60) + (H * 60 * 60) + S ;
        long delay = TotalS * 1000;
        startBtn.setDisable(true);
        timert.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run(){
                Platform.runLater(() ->{
                    int hours = TotalS / (60 * 60);
                    int minutes = TotalS / 60;
                    int seconds = TotalS % 60;
                    String T = hours + ":" + minutes + ":" + seconds ;
                    timeLeft.setText(T);
                    if(TotalS<0) {
                        Submit(new ActionEvent());
                        ExamFinished();
                    }
                    TotalS = TotalS - 1;
                });
            }
        }, 0, 1000);
    }

    @FXML
    public void Next(ActionEvent e){
        if(currIndex+1 < mxIndex) {
            ResetChoices();
            currIndex++;
            qNo.setText(String.valueOf(currIndex + 1));
            SetQuestion(Qlist.get(currIndex));
        }
    }

    @FXML
    public void Previous(ActionEvent e){
        if(currIndex > 0) {
            ResetChoices();
            currIndex--;
            qNo.setText(String.valueOf(currIndex + 1));
            SetQuestion(Qlist.get(currIndex));
        }
    }
    @FXML
    private void Choice1(ActionEvent event){
        if(choice1.isSelected()){
            choice2.setSelected(false);
            choice3.setSelected(false);
            choice4.setSelected(false);
            ch[currIndex] = 1;
        }
    }
    @FXML
    private void Choice2(ActionEvent event){
        if(choice2.isSelected()){
            choice1.setSelected(false);
            choice3.setSelected(false);
            choice4.setSelected(false);
            ch[currIndex] = 2;
        }
    }
    @FXML
    private void Choice3(ActionEvent event){
        if(choice3.isSelected()){
            choice2.setSelected(false);
            choice1.setSelected(false);
            choice4.setSelected(false);
            ch[currIndex] = 3;
        }
    }
    @FXML
    private void Choice4(ActionEvent event){
        if(choice4.isSelected()){
            choice2.setSelected(false);
            choice3.setSelected(false);
            choice1.setSelected(false);
            ch[currIndex] = 4;
        }
    }
    @FXML
    private void ResetChoices(){
        choice1.setSelected(false);
        choice2.setSelected(false);
        choice3.setSelected(false);
        choice4.setSelected(false);
    }

    @FXML
    public void SetQuestion(DBQustion qustion){
        questionTxt.setText(qustion.Question);
        choice1.setText(qustion.Choice1);
        choice2.setText(qustion.Choice2);
        choice3.setText(qustion.Choice3);
        choice4.setText(qustion.Choice4);
        if(ch[currIndex] == 1){
            choice1.setSelected(true);
            choice2.setSelected(false);
            choice3.setSelected(false);
            choice4.setSelected(false);
        }
        if(ch[currIndex] == 2){
            choice1.setSelected(false);
            choice3.setSelected(false);
            choice4.setSelected(false);
            choice2.setSelected(true);
        }
        if(ch[currIndex] == 3){
            choice1.setSelected(false);
            choice2.setSelected(false);
            choice4.setSelected(false);
            choice3.setSelected(true);
        }
        if(ch[currIndex] == 4){
            choice4.setSelected(true);
            choice1.setSelected(false);
            choice2.setSelected(false);
            choice3.setSelected(false);
        }
    }

    @FXML
    public void Submit(ActionEvent event){
        ArrayList<Pair<Integer, DBQustion>> freq = new ArrayList<>();
        for (int i=0;i<Qlist.size();i++){
            freq.add(new Pair<>(0, Qlist.get(i)));
        }

        for(int i=0;i<Qlist.size();i++){
            if(ch[i]!= -1){
                DBQustion q = Qlist.get(i);
                if((q.CorrectChoice.equals("A") && ch[i] == 1)||(q.CorrectChoice.equals("B") && ch[i] == 2)
                        ||(q.CorrectChoice.equals("C") && ch[i] == 3)||(q.CorrectChoice.equals("D") && ch[i] == 4)){
                    totalGrade += q.grade;
                }
                for(int j=0;j<freq.size();j++){
                    Pair<Integer, DBQustion> current = freq.get(j);
                    Pair<Integer, DBQustion> newValue = new Pair<>(current.getKey()+1, freq.get(j).getValue());
                    if(current.getValue().QuesID.equals(q.QuesID)){
                        freq.set(j, newValue);
                    }
                }
            }
        }
        ExamFinished();
        passData.QuestionsFreq = new ArrayList<>(freq);
    }

    public void ExamFinished(){
        timert.cancel();
        stackPane.setVisible(true);
        g.ShowDialog(stackPane, "Exam Finished", "Your Grade is: " + totalGrade + "/" + e.getById("z").totalGrade,"OK", "StudentHome.fxml");
    }
}
