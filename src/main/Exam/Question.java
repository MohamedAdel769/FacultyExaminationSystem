package main.Exam;

import com.mysql.cj.xdevapi.DbDoc;
import main.dataBaseHelper.DBQustion;

public class Question implements getFromDB {
    private int grade;
    private String ExamID,QuestionID,choice1,choice2,choice3,choice4,CorrectChoice,EvaluationRank;

    public Question(String QuestionID, int grade, String EvaluationRank, String ExamID, String choice1, String choice2, String choice3, String choice4, String CorrectChoice) {
        this.QuestionID = QuestionID;
        this.grade = grade;
        this.EvaluationRank = EvaluationRank;
        this.ExamID = ExamID;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.CorrectChoice = CorrectChoice;
    }

    public String getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(String QuestionID) {
        this.QuestionID = QuestionID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getEvaluationRank() {
        return EvaluationRank;
    }

    public void setEvaluationRank(String EvaluationRank) {
        this.EvaluationRank = EvaluationRank;
    }

    public String getExamID() {
        return ExamID;
    }

    public void setExamID(String ExamID) {
        this.ExamID = ExamID;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getCorrectChoice() {
        return CorrectChoice;
    }

    public void setCorrectChoice(String CorrectChoice) {
        this.CorrectChoice = CorrectChoice;
    }

    @Override
    public void getFromDbByid(String id) {
        DBQustion dbQustion = new DBQustion().getById(id);
        this.QuestionID = dbQustion.QuesID;
        this.grade = dbQustion.grade;
        this.EvaluationRank = dbQustion.EvaluationRankAChar;
        this.ExamID = dbQustion.examID ;
        this.choice1 = dbQustion.Choice1;
        this.choice2 = dbQustion.Choice2;
        this.choice3 = dbQustion.Choice3;
        this.choice4 = dbQustion.Choice4;
        this.CorrectChoice = dbQustion.CorrectChoice;
    }
}