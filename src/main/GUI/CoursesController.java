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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guiHelper.ValidateText(id, "Enter id", false);
        guiHelper.ValidateText(name, "Enter name", false);
        guiHelper.ValidateText(department, "Enter department" , false);
    }
    @FXML
    public void addCourse(){
        id.clear();
        name.clear();
        department.clear();
    }

}
