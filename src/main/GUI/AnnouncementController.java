package main.GUI;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import main.dataBaseHelper.DBAnnouncement;

import java.net.URL;
import java.util.ResourceBundle;

public class AnnouncementController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    private Label instName;

    @FXML
    private JFXTextField examIDTxt;

    @FXML
    private JFXTextArea bodyTxt;

    @FXML
    private JFXTextField headerTxt;

    @FXML
    private JFXButton addBtn;
    @FXML
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instName.setText(passData.instructor.Name);
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
    public void Add(ActionEvent event){
        DBAnnouncement announcement = new DBAnnouncement(GUIHelper.randomAlphaNumeric(4),passData.instructor.Username, examIDTxt.getText(), bodyTxt.getText(), headerTxt.getText());
        new DBAnnouncement().add(announcement);
        examIDTxt.clear();
        bodyTxt.clear();
        headerTxt.clear();
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
    public void Exam(ActionEvent e){
        guiHelper.GoToForm("Exams.fxml");
    }
    @FXML
    public void ExamReport(ActionEvent e){
        guiHelper.GoToForm("EvaluationExamReport.fxml");
    }
    @FXML
    public void Home(ActionEvent e){
        guiHelper.GoToForm("instructorHome.fxml");
    }
    @FXML
    public void Announcment(ActionEvent e){
        guiHelper.GoToForm("Announcement.fxml");
    }
}
