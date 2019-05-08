package main.GUI;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.Users.Student;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static main.dataBaseHelper.dataBaseConVars.*;

public class GradesController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;
    @FXML
    TableView<GradesData> GradesTableView;
    @FXML
    TableColumn<GradesData,String> Grade = new TableColumn<>("Student Grades");
    //@FXML
    //TableColumn<GradesData,String> Course = new TableColumn<>("Course");
    @FXML
    TableColumn<GradesData,String> Total_Grades = new TableColumn<>("Total Grades");





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<GradesData> items = FXCollections.observableArrayList();
       // Course.setCellValueFactory(new PropertyValueFactory("Course"));
        Total_Grades.setCellValueFactory(new PropertyValueFactory("examGrade"));
        Grade.setCellValueFactory(new PropertyValueFactory("TotalGrade"));
        startConnection();
        try{
            String query = String.format("select stdGrade,ExamGrade  from ListOfGrades");
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()){
                items.add(new GradesData(dBResult.getInt("ExamGrade"),dBResult.getInt("stdGrade")));
            }
        } catch (
                SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        GradesTableView.setItems(items);

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
    public void LogOut(ActionEvent e){
        guiHelper.GoToForm("Login.fxml");
    }
    @FXML
    public void Home(ActionEvent e){
        guiHelper.GoToForm("StudentHome.fxml");
    }
    @FXML
    public void Exam(ActionEvent e){ guiHelper.GoToForm("ExamSessions.fxml"); }
    @FXML
    public void Grades(ActionEvent e){
        guiHelper.GoToForm("Grades.fxml");
    }
}
