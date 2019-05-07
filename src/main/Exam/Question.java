package main.Exam;

public class Question {
    private int QuestionID,grade,EvaluationRank,ExamID;
    private String choice1,choice2,choice3,choice4,CorrectChoice;

    public Question(int QuestionID, int grade, int EvaluationRank, int ExamID, String choice1, String choice2, String choice3, String choice4, String CorrectChoice) {
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

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getEvaluationRank() {
        return EvaluationRank;
    }

    public void setEvaluationRank(int EvaluationRank) {
        this.EvaluationRank = EvaluationRank;
    }

    public int getExamID() {
        return ExamID;
    }

    public void setExamID(int ExamID) {
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

}