package main.Exam;

import java.util.ArrayList;

public class Histogram{
    private String Id;
    private ArrayList<Integer> listOfGrades;
    private int numberOfStudent;

    public Histogram(String id, ArrayList<Integer> listOfGrades, int numberOfStudent) {
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

    public void setListOfGrades(ArrayList<Integer> listOfGrades) {
        this.listOfGrades = listOfGrades;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

}
