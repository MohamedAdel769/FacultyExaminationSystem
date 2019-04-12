package main.Session;

import java.util.ArrayList;

public class ExamSession {
    private String ID ;
    private ArrayList<String> ListOfStudentsID ;
    private String ExamID ;

    public ExamSession(String ID, ArrayList<String> ListOfStudentsID, String ExamID){
        this.ID = ID ;
        this.ExamID = ExamID;
        this.ListOfStudentsID = ListOfStudentsID ;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<String> getListOfStudentsID() {
        return ListOfStudentsID;
    }

    public void setListOfStudentsID(ArrayList<String> listOfStudentsID) {
        ListOfStudentsID = listOfStudentsID;
    }

    public String getExamID() {
        return ExamID;
    }

    public void setExamID(String examID) {
        ExamID = examID;
    }
}
