package main.Exam;

import java.util.ArrayList;

public class Histogram{
    private String Id;
    private ArrayList<Integer> listOfGrades = null;
    private int numberOfStudent = 0;

    public Histogram(String id, ArrayList listOfGrades, int numberOfStudent) {
        Id = id;
        this.listOfGrades = listOfGrades;
        this.numberOfStudent = numberOfStudent;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public ArrayList getListOfGrades() {
        return listOfGrades;
    }

    public void setListOfGrades(ArrayList listOfGrades) {
        this.listOfGrades = listOfGrades;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

}
