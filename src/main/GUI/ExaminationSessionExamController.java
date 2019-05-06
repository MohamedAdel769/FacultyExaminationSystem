package main.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Session.ListOfExamSession;
import main.Users.Student;
import main.dataBaseHelper.DBListOfExamSessions;

import java.net.URL;
import java.util.ResourceBundle;

public class ExaminationSessionExamController implements Initializable {
    @FXML
    TableView<ListOfExamSession> table;
    @FXML
    TableColumn<ListOfExamSession,String> ExCol = new TableColumn<>("Examination Session");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ExCol.setCellValueFactory(new PropertyValueFactory("examSessionsID"));
        ObservableList<ListOfExamSession> items = FXCollections.observableArrayList(
                new ListOfExamSession("xx","zz")
        );
        table.setItems(items);
    }
    @FXML
    public void done(){

    }
}
