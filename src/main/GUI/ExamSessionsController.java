package main.GUI;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Session.ExamSession;
import main.dataBaseHelper.DBExam;
import main.dataBaseHelper.DBExaminationSession;
import main.dataBaseHelper.DBListOfExamSessions;

import java.net.URL;
import java.util.ResourceBundle;

public class ExamSessionsController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;
    @FXML
    TableColumn examSessionID;
    @FXML
    TableColumn acStatus;
    @FXML
    TableColumn<DBExaminationSession,String> emailCol = new TableColumn<>("ExamSessionID");
    @FXML
    TableColumn<DBExaminationSession,Boolean> selectCol = new TableColumn<>("acceptance status");
    @Override
        ///boolean ac = new DBExam().getById(id).acceptStatus;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        examSessionID.setCellValueFactory(new PropertyValueFactory("examSessionsID"));
        acStatus.setCellValueFactory(new PropertyValueFactory("examID"));
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
