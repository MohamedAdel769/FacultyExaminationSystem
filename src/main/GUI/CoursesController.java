package main.GUI;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.*;
import main.dataBaseHelper.DBCourse;
import main.dataBaseHelper.dataBaseConVars;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CoursesController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    private JFXTextField id , name , department ;
    @FXML
    private JFXButton add ;
    @FXML
    JFXTabPane tabPane ;
    @FXML
    JFXButton displayHisto ;
    @FXML
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guiHelper.ValidateText(id, "Enter id", false);
        guiHelper.ValidateText(name, "Enter name", false);
        guiHelper.ValidateText(department, "Enter department" , false);
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
    public void addCourse(){
        String idValue = id.getText();
        String nameValue = name.getText();
        String dapValue = department.getText();
        if(new DBCourse().add(new DBCourse(idValue, nameValue, dapValue, passData.instructor.Username)) == dataBaseConVars.OK ){
            id.clear();
            name.clear();
            department.clear();
        }else{
            System.out.println("NOT added");
        }

    }
    @FXML
    public void Search(ActionEvent e){
        // if we have this exam id and duration is finished then

        tabPane.setDisable(false);
        displayHisto.setDisable(false);
    }
    @FXML
    public void LogOut(ActionEvent e){
        guiHelper.GoToForm("Login.fxml");
    }
    @FXML
    public void addCourses(ActionEvent e){
        guiHelper.GoToForm("Courses.fxml");
    }

    @FXML
    public void Exam(ActionEvent e){ guiHelper.GoToForm("Exams.fxml"); }
    @FXML
    public void ExamReport(ActionEvent e){
        guiHelper.GoToForm("EvaluationExamReport.fxml");
    }
    @FXML
    public void Home(ActionEvent e){
        guiHelper.GoToForm("instructorHome.fxml");
    }
}
