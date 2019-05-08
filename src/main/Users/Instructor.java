package main.Users;

import main.dataBaseHelper.DBInstructor;

public class Instructor extends User{

    public Instructor(String name, String phone, String email, int age, String username, String password) {
        super(name, phone, email, age, username, password);
    }

    public Instructor(String id, String name, String email) {
        super(id, name, email);
    }

    public void getFromDbByUserName(String username){
        DBInstructor dbInstructor = new DBInstructor().getByUsername(username);
        this.setName(dbInstructor.Name);
        this.setPhone(dbInstructor.Phone);
        this.setEmail(dbInstructor.Email);
        this.setAge(Integer.parseInt(dbInstructor.Age));
        this.setUsername(dbInstructor.Username);
        this.setPassword(dbInstructor.Password);
    }

}