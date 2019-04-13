package main.Users;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class Student extends  User{
   // List<exam> ExamsWithGrades;
   Student(String name, int phone, String email , int age, String id, String username, String password) {
       super(new SimpleStringProperty(name),phone,new SimpleStringProperty(email),age,new SimpleStringProperty(id),new SimpleStringProperty(username),new SimpleStringProperty(password));
   }
}
