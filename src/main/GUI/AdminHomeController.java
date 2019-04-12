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

    @FXML
    TableColumn idCol , nameCol , emailCol, checkCol ;
    @FXML
    TableView tableView ;

    @FXML
    StackPane stackPane ;

    @FXML
    public void Logout(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            Main.window.setScene(scene);
            Main.window.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void CreateSession(ActionEvent event){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Examination Session"));
        content.setBody(new Text("You successfully added a new Examination Session."));
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);

        JFXButton button = new JFXButton("Ok");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        dialog.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
