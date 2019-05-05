package main.GUI;

import main.dataBaseHelper.DBInstructor;
import main.dataBaseHelper.DBStudent;

import java.util.HashMap;

public final class passData {
    public static DBInstructor instructor = new DBInstructor();
    public static DBStudent Student = new DBStudent();
    public static HashMap<String ,String > data = new HashMap<>();
}
