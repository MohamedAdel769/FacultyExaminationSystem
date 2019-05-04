package main.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import main.Users.Student;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AdminHomeController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    TableView<Student> adminTableView;

    @FXML
    StackPane stackPane ;

    @FXML
    public void Logout(ActionEvent event){
        guiHelper.GoToForm("Login.fxml");
    }

    @FXML
    public void CreateSession(ActionEvent event){
        /*for(Object row: adminTableView.getItems()){
            for(TableColumn col: adminTableView.getColumns()){
                Object data = col.getCellObservableValue(row);
                try{
                    String value = (String)data ;
                    // System.out.println(value);
                }catch(Exception e){
                    CheckBox select = (CheckBox)data ;
                   //  System.out.println(select.isSelected());
                }
            }
        }*/
        guiHelper.ShowDialog(stackPane, "Examination Session", "You successfully added a new examination session.", "Ok");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<Student,String> idCol = new TableColumn<>("ID");
        TableColumn<Student,String> nameCol = new TableColumn<>("Name");
        TableColumn<Student,String> emailCol = new TableColumn<>("E-mail");
        TableColumn<Student,String> selectCol = new TableColumn<>("Select");
        nameCol.setCellValueFactory(new PropertyValueFactory("Name"));
        emailCol.setCellValueFactory(new PropertyValueFactory("Phone"));
        idCol.setCellValueFactory(new PropertyValueFactory("email"));
        selectCol.setCellValueFactory(new PropertyValueFactory("Username"));
        idCol.setPrefWidth(100.0);
        nameCol.setPrefWidth(150.0);
        emailCol.setPrefWidth(200.0);
        idCol.setResizable(false);
        nameCol.setResizable(false);
        emailCol.setResizable(false);
        selectCol.setResizable(false);
        selectCol.setStyle("-fx-alignment: center;");
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
