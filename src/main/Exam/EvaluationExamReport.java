package main.Exam;

import java.util.ArrayList;

public class EvaluationExamReport {
    private String ExamID ;
    private String HistogramID ;
    private ArrayList<Character> TopQuestions ;

    public EvaluationExamReport(String ExamID, String HistogramID, ArrayList<Character> TopQuestions){
        this.ExamID = ExamID ;
        this.HistogramID = HistogramID ;
        this.TopQuestions = TopQuestions ;
    }

    public String getExamID() {
        return ExamID;
    }

    public void setExamID(String examID) {
        ExamID = examID;
    }

    public String getHistogramID() {
        return HistogramID;
    }

    public void setHistogramID(String histogramID) {
        HistogramID = histogramID;
    }

    public ArrayList<Character> getTopQuestions() {
        return TopQuestions;
    }

    public void setTopQuestions(ArrayList<Character> topQuestions) {
        TopQuestions = topQuestions;
    }
}
