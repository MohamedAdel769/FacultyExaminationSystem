package main.Users;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;


public abstract class User implements getFromDB {

    private SimpleStringProperty name;
    private SimpleStringProperty phone;
    private SimpleStringProperty email;
    private int age;
    private SimpleStringProperty id;
    private SimpleStringProperty username;
    private SimpleStringProperty Password;
    private CheckBox selectStd ;

    User(String name, String phone, String email, int age, String username, String password) {
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.age = age;
        this.username = new SimpleStringProperty(username);
        this.Password =  new SimpleStringProperty(password);
        this.selectStd=new CheckBox();
    }

    User(String name, String phone, String email, String id, String username, String password) {
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.id = new SimpleStringProperty(id);
        this.username = new SimpleStringProperty(username);
        this.Password =  new SimpleStringProperty(password);
        this.selectStd=new CheckBox();
    }

    User(String id, String name, String email) {
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.id = new SimpleStringProperty(id);
        this.selectStd=new CheckBox();
    }

    public CheckBox getSelectStd() {
        return selectStd;
    }

    public void setSelectStd(CheckBox selectStd) {
        this.selectStd = selectStd;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return Password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password.set(password);
    }
}
