package main.GUI;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.*;
import main.dataBaseHelper.DBInstructor;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class InstructorHomeController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;
    @FXML
    ImageView profileImg ;
    @FXML
    JFXTextField nameTxt , phoneTxt, emailTxt, ageTxt ;
    @FXML
    Label userName ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        nameTxt.setText(passData.instructor.Name);
        phoneTxt.setText(passData.instructor.Phone);
        emailTxt.setText(passData.instructor.Email);
        ageTxt.setText(passData.instructor.Age);
        userName.setText(passData.instructor.Username);
    }

    @FXML
    public void addImage(ActionEvent e)  {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("128x128 - png", "*.png"), new FileChooser.ExtensionFilter("128x128 - jpg", "*.jpg"));
        try{
            File file = fileChooser.showOpenDialog(null);
            String path = file.toURI().toURL().toString() ;

            Image image = new Image(path);
            profileImg.setImage(image);
            profileImg.setPreserveRatio(true);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"You didn't choose a photo", "Warning",JOptionPane.WARNING_MESSAGE);
        }
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
    public void save(){
        String name = nameTxt.getText();
        String id = passData.instructor.Username;
        String pass = passData.instructor.Password;
        String age = (ageTxt.getText());
        String phone = phoneTxt.getText();
        String email = emailTxt.getText();
        new DBInstructor().update(new DBInstructor(name, phone, email, age , id , pass));
    }
}
