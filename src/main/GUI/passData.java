package main.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;
import main.dataBaseHelper.DBExam;
import main.dataBaseHelper.DBInstructor;
import main.dataBaseHelper.DBQustion;
import main.dataBaseHelper.DBStudent;

import java.util.ArrayList;
import java.util.HashMap;

public final class passData {
    public static DBInstructor instructor = new DBInstructor();
    public static DBStudent Student = new DBStudent();
    public static DBExam Exam = new DBExam();
    public static ObservableList<String> Corseslist = FXCollections.observableArrayList();
    public static String chosenExam = "";
    public static int numOfQ = 0;
    public static String examID = new String();
    public static ArrayList<Pair<Integer, DBQustion>> Question_num = new ArrayList<>();
}
