package main.Exam;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class ExamSession {
    public SimpleStringProperty ID ;
    public ArrayList<String> ListOfStudentsID ;
    public SimpleStringProperty ExamID;

    public ExamSession(String ID, ArrayList<String> ListOfStudentsID, String ExamID){
        this.ID =new SimpleStringProperty(ID) ;
        this.ExamID = new SimpleStringProperty(ExamID);
        this.ListOfStudentsID = ListOfStudentsID ;
    }

    public ExamSession(String ID, String examID) {
        this.ID =new SimpleStringProperty(ID) ;
        this.ExamID = new SimpleStringProperty(examID);
    }

    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public ArrayList<String> getListOfStudentsID() {
        return ListOfStudentsID;
    }

    public void setListOfStudentsID(ArrayList<String> listOfStudentsID) {
        ListOfStudentsID = listOfStudentsID;
    }

    public String getExamID() {
        return ExamID.get();
    }

    public SimpleStringProperty examIDProperty() {
        return ExamID;
    }

    public void setExamID(String examID) {
        this.ExamID.set(examID);
    }
}
