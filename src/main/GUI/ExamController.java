package main.GUI;

import com.jfoenix.controls.JFXButton;
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
    int currIndex  = 0, mxIndex ;
    @FXML
    JFXTextArea questionTxt ;
    @FXML
    JFXCheckBox choice1 ,choice2, choice3 , choice4 ;
    @FXML
    Label qNo ;
    @FXML
    JFXButton prebtn , nextbtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       dbQ  = new DBQustion();
       Qlist  = new ArrayList<>(dbQ.getByExamId("z"));
       mxIndex = Qlist.size() - 1 ;
       currIndex = 0 ;
       qNo.setText("1");
       SetQuestion(Qlist.get(currIndex));
       System.out.println(Qlist.size());
       prebtn.setVisible(false);
    }

    @FXML
    public void Next(ActionEvent e){
        if(currIndex < Qlist.size()) {
            currIndex++;
            qNo.setText(String.valueOf(currIndex + 1));
            SetQuestion(Qlist.get(currIndex));
        }
        if(currIndex == Qlist.size()-1)
            nextbtn.setVisible(false);
        prebtn.setVisible(true);
    }

    @FXML
    public void Previous(ActionEvent e){
        if(currIndex > 0) {
            currIndex--;
            qNo.setText(String.valueOf(currIndex + 1));
            SetQuestion(Qlist.get(currIndex));
        }
        if(currIndex == 0)
            prebtn.setVisible(false);
        nextbtn.setVisible(true);

    }

    @FXML
    public void SetQuestion(DBQustion qustion){
        questionTxt.setText(qustion.Question);
        choice1.setText(qustion.Choice1);
        choice2.setText(qustion.Choice2);
        choice3.setText(qustion.Choice3);
        choice4.setText(qustion.Choice4);
        choice1.setSelected(false);
        choice2.setSelected(false);
        choice3.setSelected(false);
        choice4.setSelected(false);
    }
}
