package main.GUI;

import com.jfoenix.controls.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import main.Main;

import javax.swing.*;
import javax.swing.text.TabableView;
import javax.swing.text.TableView;
import java.awt.*;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {
    GUIHelper guiHelper = new GUIHelper();
    @FXML
    TableColumn idCol , nameCol , emailCol, checkCol ;
    @FXML
    TableView tableView ;

    @FXML
    StackPane stackPane ;

    @FXML
    public void Logout(ActionEvent event){
        guiHelper.GoToForm("Login.fxml");
    }

    @FXML
    public void CreateSession(ActionEvent event){
        guiHelper.ShowDialog(stackPane, "Examination Session", "You successfully added a new examination session.", "Ok");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
