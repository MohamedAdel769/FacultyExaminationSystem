package main.GUI;

import javafx.beans.property.SimpleStringProperty;

public class GradesData {
    private int examGrade;
    private int TotalGrade;
    private SimpleStringProperty C_name;

    GradesData(String Course, int examGrade,int TotalGrade){
        this.examGrade = examGrade;
        this.TotalGrade =TotalGrade;
        this.C_name = new SimpleStringProperty(Course);
    }
    GradesData(){}

    public int getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(int examGrade) {
        this.examGrade = examGrade;
    }

    public int getTotalGrade() {
        return TotalGrade;
    }

    public void setTotalGrade(int totalGrade) {
        TotalGrade = totalGrade;
    }

    public String getC_name() {
        return C_name.get();
    }

    public SimpleStringProperty c_nameProperty() {
        return C_name;
    }

    public void setC_name(String c_name) {
        this.C_name.set(c_name);
    }
}
