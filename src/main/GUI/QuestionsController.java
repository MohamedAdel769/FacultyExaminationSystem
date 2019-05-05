package main.GUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.dataBaseHelper.DBQustion;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionsController implements Initializable {
    private GUIHelper guiHelper = new GUIHelper() ;
    @FXML
    JFXTextArea QtxtArea;
    @FXML
    JFXTextField Q1txt;
    @FXML
    JFXTextField Q2txt;
    @FXML
    JFXTextField Q3txt;
    @FXML
    JFXTextField Q4txt;
    @FXML
    JFXTextField Gradetxt;
    @FXML
    JFXTextField examID;
    @FXML
    JFXComboBox Answertxt;
    @FXML
    JFXComboBox EvRank;

    ObservableList<String> list = FXCollections.observableArrayList("A", "B","C","D");
    ObservableList<String> listt = FXCollections.observableArrayList("A", "B","C","D");

    @FXML
    public void add()
    {
        int n = Integer.parseInt(Gradetxt.getText());
        DBQustion Q = new DBQustion(Q1txt.getText(),Q2txt.getText(),Q3txt.getText(),Q4txt.getText(),Answertxt.getValue().toString(),n,EvRank.getValue().toString(),examID.getText(),QtxtArea.getText());
        Q.add(Q);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Answertxt.setItems(list);
        EvRank.setItems(listt);
    }
}
