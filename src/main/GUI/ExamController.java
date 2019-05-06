package main.GUI;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import main.dataBaseHelper.DBQustion;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;

public class ExamController implements Initializable {
    ArrayList<DBQustion> Qlist ;
    DBQustion dbQ ;
    int currIndex , mxIndex ;
    @FXML
    JFXTextArea questionTxt ;
    @FXML
    JFXCheckBox choice1 ,choice2, choice3 , choice4 ;
    @FXML
    Label qNo ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       dbQ  = new DBQustion();
       Qlist  = new ArrayList<>(dbQ.getByExamId("z"));
       mxIndex = Qlist.size() - 1 ;
       currIndex = 0 ;
       qNo.setText("1");
       SetQuestion(Qlist.get(currIndex));



    }

    @FXML
    public void Next(ActionEvent e){
        currIndex++;
        qNo.setText(String.valueOf(currIndex+1));
        SetQuestion(Qlist.get(currIndex));
    }

    @FXML
    public void Previous(ActionEvent e){
        currIndex--;
        qNo.setText(String.valueOf(currIndex+1));
        SetQuestion(Qlist.get(currIndex));
    }

    @FXML
    public void SetQuestion(DBQustion qustion){
        questionTxt.setText(qustion.Question);
        choice1.setText(qustion.Choice1);
        choice2.setText(qustion.Choice2);
        choice3.setText(qustion.Choice3);
        choice4.setText(qustion.Choice4);
    }
}
