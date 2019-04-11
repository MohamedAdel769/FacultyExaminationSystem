package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

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
    final String tableName = "Qustion";

    public DBQustion(String quesID, String choice1, String choice2, String choice3, String choice4, String correctChoice, int grade, String evaluationRankAChar, String examID) {
        QuesID = quesID;
        Choice1 = choice1;
        Choice2 = choice2;
        Choice3 = choice3;
        Choice4 = choice4;
        CorrectChoice = correctChoice;
        this.grade = grade;
        EvaluationRankAChar = evaluationRankAChar;
        this.examID = examID;
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
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return tem;
    }
    public int add(DBQustion tem) {
        try {
            startConnection();
            String s = "";
            String query = String.format("insert into %s (QuesID,Choice1, Choice2, Choice3, Choice4, CorrectChoice, grade, EvaluationRank, examID)" +
                    "values ('%s','%s','%s','%s','%s', '%s' ,%d ,'%s','%s')",tableName,tem.QuesID,tem.Choice1,tem.Choice2
                    ,tem.Choice3,tem.Choice4 , tem.CorrectChoice,tem.grade,tem.EvaluationRankAChar,tem.examID);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
}
