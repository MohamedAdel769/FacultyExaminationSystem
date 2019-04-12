package main.GUI;

import com.jfoenix.controls.*;

import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import main.Main;

public class GUIHelper {

    public void GoToForm(String FormName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(FormName));
            Scene scene = new Scene(root);
            Main.window.setScene(scene);
            Main.window.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ValidateText(JFXTextField Txt, String Message, boolean isNum){
        if(Txt.isEditable()) {
            if(isNum){
                NumberValidator validator = new NumberValidator();
                Txt.getValidators().add(validator);
                validator.setMessage(Message);
                Txt.focusedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                        if (!t1) {
                            Txt.validate();
                        }
                    }
                });
                ImageView warn = new ImageView("/imgs/round-error-symbol.png");
                validator.setIcon(warn);
            }
            else{
                RequiredFieldValidator validator = new RequiredFieldValidator();
                Txt.getValidators().add(validator);
                validator.setMessage(Message);
                Txt.focusedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                        if (!t1) {
                            Txt.validate();
                        }
                    }
                });
                ImageView warn = new ImageView("/imgs/round-error-symbol.png");
                validator.setIcon(warn);
            }
        }
    }

    public void ValidateText(JFXPasswordField Txt, String Message){
        RequiredFieldValidator validator = new RequiredFieldValidator();
        Txt.getValidators().add(validator);
        validator.setMessage(Message);
        Txt.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (!t1) {
                    Txt.validate();
                }
            }
        });
        ImageView warn = new ImageView("/imgs/round-error-symbol.png");
        validator.setIcon(warn);
    }

    public void ShowDialog(StackPane stackPane, String Heading, String Body, String ButtonTxt){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text(Heading));
        content.setBody(new Text(Body));
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);

        JFXButton button = new JFXButton(ButtonTxt);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button);
        dialog.show();
    }
}
