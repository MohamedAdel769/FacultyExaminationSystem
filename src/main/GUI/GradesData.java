package main.GUI;

public class GradesData {
    private int examGrade;
    private int TotalGrade;


    GradesData( int examGrade,int TotalGrade){
        this.examGrade = examGrade;
        this.TotalGrade =TotalGrade;
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
}
