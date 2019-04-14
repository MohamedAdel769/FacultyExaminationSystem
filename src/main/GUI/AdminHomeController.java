package main.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Users.Student;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {

    @FXML
    TableView<Student> adminTableView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<Student,String> idCol = new TableColumn<>("ID");
        TableColumn<Student,String> nameCol = new TableColumn<>("Name");
        TableColumn<Student,String> emailCol = new TableColumn<>("E-mail");
        TableColumn<Student,String> selectCol = new TableColumn<>("Select");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        selectCol.setCellValueFactory(new PropertyValueFactory("selectStd"));
        adminTableView.getColumns().addAll(idCol,nameCol,emailCol,selectCol);
        ObservableList<Student> items = FXCollections.observableArrayList(
                new Student("mahmood","madfb@","50",new CheckBox()),
                new Student("s sdv","madfb@","50",new CheckBox()),
                new Student("sdvggb","madfb@","50",new CheckBox()),
                new Student("tyrtu","madfb@","50",new CheckBox()),
                new Student("io,im","madfb@","50",new CheckBox()),
                new Student("wxedweff","madfb@","50",new CheckBox()),
                new Student("mahmood","madfb@","50",new CheckBox()),
                new Student("mahmood","madfb@","50",new CheckBox())
        );
        adminTableView.setItems(items);
    }
}
