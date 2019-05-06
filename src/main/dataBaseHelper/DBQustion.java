package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.OK;

public class DBQustion {
    String QuesID = null;
    String Choice1 = null;
    String Choice2 = null;
    String Choice3 = null;
    String Choice4 = null;
    String CorrectChoice;
    int grade = 0;
    String EvaluationRankAChar ;
    String examID  = null;
    String Question = null;
    final String tableName = "Questions";

    public DBQustion( String choice1, String choice2, String choice3, String choice4, String correctChoice, int grade, String evaluationRankAChar, String examID,String Question) {
        Choice1 = choice1;
        Choice2 = choice2;
        Choice3 = choice3;
        Choice4 = choice4;
        CorrectChoice = correctChoice;
        this.grade = grade;
        EvaluationRankAChar = evaluationRankAChar;
        this.examID = examID;
        this.Question = Question;
    }

    public DBQustion() {

    }

    public DBQustion getById(String id) {
        startConnection();
        DBQustion tem = new DBQustion();
        try {
            String query = String.format("select * from %s where QuesID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.QuesID = dBResult.getString("QuesID");
                tem.Choice1 = dBResult.getString("Choice1");
                tem.Choice2 = dBResult.getString("Choice2");
                tem.Choice3 = dBResult.getString("Choice3");
                tem.Choice4 = dBResult.getString("Choice4");
                tem.CorrectChoice = dBResult.getString("CorrectChoice");
                tem.grade = dBResult.getInt("grade");
                tem.EvaluationRankAChar = dBResult.getString("EvaluationRank");
                tem.examID = dBResult.getString("examID");
                tem.Question = dBResult.getString("Question");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return tem;
    }
    public Vector<DBQustion> getByExamId(String id){
        startConnection();
        DBQustion tem = new DBQustion();
        Vector<DBQustion> v = new Vector<>();
        try {
            String query = String.format("select * from %s where examID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.QuesID = dBResult.getString("QuesID");
                tem.Choice1 = dBResult.getString("Choice1");
                tem.Choice2 = dBResult.getString("Choice2");
                tem.Choice3 = dBResult.getString("Choice3");
                tem.Choice4 = dBResult.getString("Choice4");
                tem.CorrectChoice = dBResult.getString("CorrectChoice");
                tem.grade = dBResult.getInt("grade");
                tem.EvaluationRankAChar = dBResult.getString("EvaluationRank");
                tem.examID = dBResult.getString("examID");
                v.add(tem);
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return v;
    }
    public int add(DBQustion tem) {
        try {
            startConnection();
            String s = "";
            String query = String.format("insert into %s (Choice1, Choice2, Choice3, Choice4, CorrectChoice, grade, EvaluationRank, examID,Question)" +
                    "values ('%s','%s','%s','%s', '%s' ,%d ,'%s','%s','%s')",tableName,tem.Choice1,tem.Choice2
                    ,tem.Choice3,tem.Choice4 , tem.CorrectChoice,tem.grade,tem.EvaluationRankAChar,tem.examID,tem.Question);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
}
