package main.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Exam.ExamSession;
import main.dataBaseHelper.DBExaminationSession;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ExaminationSessionExamController implements Initializable {
    @FXML
    TableView<ExamSession> table;
    @FXML
    TableColumn<ExamSession,String> ExCol = new TableColumn<>("Examination Exam");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ExCol.setCellValueFactory(new PropertyValueFactory("ID"));
        ObservableList<ExamSession> items = FXCollections.observableArrayList();
        ArrayList<DBExaminationSession> list = new DBExaminationSession().getAll();
        for(int i = 0;i<list.size();i++){
            if(list.get(i).examID == null ||list.get(i).examID.equals("null"))
                items.add(new ExamSession(list.get(i).examSessionsID,null));
        }
        table.setItems(items);
    }
    @FXML
public void done(){
        ExamSession h = table.getSelectionModel().getSelectedItem();
        DBExaminationSession es = new DBExaminationSession(h.ID.getValue(),passData.Exam.examId);
        new DBExaminationSession().update(es);
        System.out.println(h.ID);
        ObservableList<ExamSession> items = FXCollections.observableArrayList();
        ArrayList<DBExaminationSession> list = new DBExaminationSession().getAll();
        for(int i = 0;i<list.size();i++){
            if(list.get(i).examID == null ||list.get(i).examID.equals("null"))
                items.add(new ExamSession(list.get(i).examSessionsID,null));
        }
        table.setItems(items);
        new GUIHelper().GoToForm("InstructorHome.fxml");
    }
}
