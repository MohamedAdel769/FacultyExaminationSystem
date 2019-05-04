package main.GUI;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
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
import main.dataBaseHelper.DBInstructor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class InstructorHomeController implements Initializable {
    @FXML
    JFXDrawersStack Drawer ;
    @FXML
    JFXHamburger hamburger ;
    @FXML
    VBox vBox ;
    @FXML
    ImageView profileImg ;
    @FXML
    static JFXTextField nameTxt , phoneTxt, emailTxt, passTxt , ageTxt ;
    @FXML
    static Label userNameTxt ;

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
}
