package main.Users;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import main.dataBaseHelper.DBInstructor;
import main.dataBaseHelper.DBStudent;

import java.util.List;

public class Student extends  User{

    public Student(String name, String phone, String email, int age, String id, String username, String password) {
        super(name, phone, email, age, id, username, password);
    }
    public Student(String id, String name, String email ) {
        super( id,name, email);
    }

    public void getFromDbByUserName(String username){
        DBStudent dbStudent = new DBStudent().getByUsername(username);
        this.setName(dbStudent.Name);
        this.setPhone(dbStudent.Phone);
        this.setUsername(dbStudent.Username);
        this.setPassword(dbStudent.Password);
    }
}