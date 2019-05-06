package main.GUI;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import main.Users.Student;
import main.dataBaseHelper.DBListOfExamSessions;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

import static main.dataBaseHelper.dataBaseConVars.*;


public class AdminHomeController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    TableView<Student> adminTableView;
    @FXML
    JFXTextField SessionID;
    @FXML
    StackPane stackPane ;
    @FXML
    TableColumn<Student,String> idCol = new TableColumn<>("ID");
    @FXML
    TableColumn<Student,String> nameCol = new TableColumn<>("Name");
    @FXML
    TableColumn<Student,String> emailCol = new TableColumn<>("E-mail");
    @FXML
    TableColumn<Student,Boolean> selectCol = new TableColumn<>("Select");

    @FXML
    public void Logout(ActionEvent event){
        guiHelper.GoToForm("Login.fxml");
    }

    @FXML
    public void CreateSession(ActionEvent event){
        Vector<Student> v = new Vector<>();
        for(int i = 0;i<adminTableView.getItems().size();i++){
            if(adminTableView.getItems().get(i).getSelectStd().isSelected()){
                v.add(adminTableView.getItems().get(i));
                adminTableView.getItems().get(i).getSelectStd().setSelected(false);
            }
        }
        for(Student S : v){
            DBListOfExamSessions L = new DBListOfExamSessions(S.getId(),SessionID.getText());
            L.add(L);
        }
        SessionID.setText(null);
        guiHelper.ShowDialog(stackPane, "Examination Session", "You successfully added a new examination session.", "Ok");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        selectCol.setCellValueFactory(new PropertyValueFactory("selectStd"));
        ObservableList<Student> items = FXCollections.observableArrayList();
        startConnection();
        try{
        String query = String.format("select stdID,Name,Email  from Student ORDER BY stdID ASC");
        dBResult = stmt.executeQuery(query);
        while (dBResult.next()){
            items.add(new Student(dBResult.getString("stdID"),dBResult.getString("Name"),dBResult.getString("Email")));
        }
    } catch (
    SQLException ex) {
        System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
    }
        adminTableView.setItems(items);
    }
}
