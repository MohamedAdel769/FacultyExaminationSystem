package main.dataBaseHelper;

import javafx.util.Pair;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.OK;

public class DBQustion {
   public String QuesID = null;
   public String Choice1 = null;
   public String Choice2 = null;
   public String Choice3 = null;
   public String Choice4 = null;
   public String CorrectChoice;
   public int grade = 0;
   public String EvaluationRankAChar ;
   public String examID  = null;
   public String Question = null;
   public int num = 0;
   public final String tableName = "Questions";

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

    public DBQustion(String quesID, String choice1, String choice2, String choice3, String choice4, String correctChoice, int grade, String evaluationRankAChar, String examID, String question, int num) {
        QuesID = quesID;
        Choice1 = choice1;
        Choice2 = choice2;
        Choice3 = choice3;
        Choice4 = choice4;
        CorrectChoice = correctChoice;
        this.grade = grade;
        EvaluationRankAChar = evaluationRankAChar;
        this.examID = examID;
        Question = question;
        this.num = num;
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
                tem.num = dBResult.getInt("num");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }finally {
            close();
        }
        return tem;
    }
    public Vector<DBQustion> getByExamId(String id){
        startConnection();
        Vector<DBQustion> v = new Vector<>();
        try {
            String query = String.format("select * from %s where examID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                DBQustion tem = new DBQustion();
                tem.QuesID = dBResult.getString("QuesID");
                tem.Choice1 = dBResult.getString("Choice1");
                tem.Choice2 = dBResult.getString("Choice2");
                tem.Choice3 = dBResult.getString("Choice3");
                tem.Choice4 = dBResult.getString("Choice4");
                tem.CorrectChoice = dBResult.getString("CorrectChoice");
                tem.grade = dBResult.getInt("grade");
                tem.EvaluationRankAChar = dBResult.getString("EvaluationRank");
                tem.examID = dBResult.getString("examID");
                tem.num = dBResult.getInt("num");
                v.add(tem);
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }finally {
            close();
        }
        return v;
    }

    public ArrayList<Pair<Integer , DBQustion>> getHis(String id){
        startConnection();
        ArrayList<Pair<Integer , DBQustion>> v = new ArrayList<Pair<Integer , DBQustion>>();
        try {
            String query = String.format("select * from %s where examID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                DBQustion tem = new DBQustion();
                tem.QuesID = dBResult.getString("QuesID");
                tem.Choice1 = dBResult.getString("Choice1");
                tem.Choice2 = dBResult.getString("Choice2");
                tem.Choice3 = dBResult.getString("Choice3");
                tem.Choice4 = dBResult.getString("Choice4");
                tem.CorrectChoice = dBResult.getString("CorrectChoice");
                tem.grade = dBResult.getInt("grade");
                tem.EvaluationRankAChar = dBResult.getString("EvaluationRank");
                tem.examID = dBResult.getString("examID");
                tem.num = dBResult.getInt("num");
                tem.Question = dBResult.getString("Question");
                v.add(new Pair<Integer, DBQustion>(tem.num ,tem));
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }finally {
            close();
        }
        return v;
    }

    public int add(DBQustion tem) {
        try {
            startConnection();
            String s = "";
            String query = String.format("insert into %s (Choice1, Choice2, Choice3, Choice4, CorrectChoice, grade, EvaluationRank, examID,Question , num)" +
                    "values ('%s','%s','%s','%s', '%s' ,%d ,'%s','%s','%s' , %d )",tableName,tem.Choice1,tem.Choice2
                    ,tem.Choice3,tem.Choice4 , tem.CorrectChoice,tem.grade,tem.EvaluationRankAChar,tem.examID,tem.Question , tem.num);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
    public void plusById(String id){
        try {
            int x = new DBQustion().getById(id).num +1;
            startConnection();
            String query = String.format("update Questions set num = %d where QuesID = '%s' ",x , id);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
    }
}
