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
import main.dataBaseHelper.DBInstructor;
import main.dataBaseHelper.DBStudent;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentHomeController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    private JFXTextField nameTxt ;
    @FXML
    private JFXTextField idTxt ;
    @FXML
    private JFXTextField phoneTxt ;
    @FXML
    private JFXTextField emailTxt ;
    @FXML
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;
    @FXML
    ImageView profileImg;
    @FXML
    Label userNameTxt ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userNameTxt.setText(passData.Student.Username);

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
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            hamTrans.setRate(hamTrans.getRate() * -1);
            hamTrans.play();
            Drawer.toggle(leftDrawer);
            if (hamTrans.getRate() == 1)
                Drawer.setPrefWidth(185);
            else
                Drawer.setPrefWidth(55);
        });
        nameTxt.setText(passData.Student.Username);
        //passF.setText(passData.instructor.Password);
        phoneTxt.setText(passData.Student.Phone);
        emailTxt.setText(passData.Student.email);
        idTxt.setText(passData.Student.stdID);
    }

    @FXML
    public void addImage(ActionEvent e)  {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("128x128 - png", "*.png"), new FileChooser.ExtensionFilter("128x128 - jpg", "*.jpg"));
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
    public void save(){
        String name = nameTxt.getText();
        String username = passData.Student.Username;
        String id = passData.Student.stdID;
        String pass = passData.Student.Password;
        String phone = phoneTxt.getText();
        String email = emailTxt.getText();
        new DBStudent().update(new DBStudent( id , name, phone, email , username , pass));
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
