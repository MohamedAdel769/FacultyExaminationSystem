package main.Users;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

import java.util.List;

public class Student extends  User{

    public Student(String name, String phone, String email, int age, String id, String username, String password) {
        super(name, phone, email, age, id, username, password);
    }

    public Student(String name, String email, String id, CheckBox selectStd) {
        super(name, email, id, selectStd);
    }
}
// List<exam> ExamsWithGrades;
