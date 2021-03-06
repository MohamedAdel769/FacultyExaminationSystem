package main.GUI;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.dataBaseHelper.DBExam;
import main.dataBaseHelper.DBExaminationSession;
import main.dataBaseHelper.DBListOfExamSessions;

import javax.swing.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    TableColumn<tableData,String> examSessionID = new TableColumn<>("ExamSessionID");
    @FXML
    TableColumn<tableData,String> acStatus = new TableColumn<>("acceptance status");
    @FXML
    TableView<tableData> tableView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList < tableData > print = FXCollections.observableArrayList();
        examSessionID.setCellValueFactory(new PropertyValueFactory("fff"));
        acStatus.setCellValueFactory(new PropertyValueFactory("sss"));
        String curStudent = passData.Student.stdID;
        ArrayList<DBListOfExamSessions> lol = new DBListOfExamSessions().getByStudentId(passData.Student.stdID);
        // getByStudentId -> elmafrood yb3tle el sessions ele feha active exams bs
        ArrayList < DBExaminationSession > v = new ArrayList<>();
        for(int i = 0 ; i < lol.size() ; i++){
            if (lol.get(i).StuID.equals(curStudent))
                v.add(new DBExaminationSession().getById(lol.get(i).examSessionsID));
        }
        for(int i = 0 ; i < v.size() ; i++){
            String id = v.get(i).examID;
            boolean ac = checkDate(new DBExam().getById(v.get(i).examID).handlingTimer) ;
            tableData temp = new tableData();
            temp.fff = new SimpleStringProperty(v.get(i).examSessionsID);
            if (ac){
                temp.sss = new SimpleStringProperty("Yes");
            }
            else {
                temp.sss = new SimpleStringProperty("No");
            }
            print.add(temp);
        }
        tableView.setItems(print);
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

    public boolean checkDate(String deadline){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String [] dt = simpleDateFormat.format(date).split(" ");
        String [] deadlineTime = deadline.split(":");
        String [] currentTime = dt[1].split(":");
        int dH = Integer.parseInt(deadlineTime[0]) , dM = Integer.parseInt(deadlineTime[1]) , cH = Integer.parseInt(currentTime[0]) , cM = Integer.parseInt(currentTime[1]) ;
        if(dH > cH){
            return true ;
        }
        else if(dH == cH){
            return (dM > cM);
        }
        else {
            return false;
        }
    }

    @FXML
    public void takeExamButton(ActionEvent e) {
        // shof anhe selected
        tableData chosen = tableView.getSelectionModel().getSelectedItem();
        // ro7 lel exam ele 3mltlo select
        if(chosen.getSss().equals("Yes")){
            passData.chosenExam =  chosen.fff.getValue();
            new GUIHelper().GoToForm("Exam.fxml");
        }
        else{
            JOptionPane.showMessageDialog(null, "This Exam Session has ended.");
        }
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
