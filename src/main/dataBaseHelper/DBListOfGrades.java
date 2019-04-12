package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBListOfGrades {
    String stdID = null;
    String examID = null;
    int stdGrade = 0;
    final String tableName = "ListOfGrades";

    public DBListOfGrades(String stdID, String examID, int stdGrade) {
        this.stdID = stdID;
        this.examID = examID;
        this.stdGrade = stdGrade;
    }

    public DBListOfGrades() {
    }

    public DBListOfGrades getById(String id) {
        startConnection();
        DBListOfGrades tem = new DBListOfGrades();
        try {
            String query = String.format("select * from %s where stdID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.examID = dBResult.getString("examID");
                tem.stdID = dBResult.getString("stdID");
                tem.stdGrade = dBResult.getInt("stdGrade");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return tem;
    }
    public int add(DBListOfGrades tem) {
        try {
            startConnection();
            String query = String.format("insert into %s (stdID , examID , stdGrade  )" +
                    "values ('%s','%s' , %d) ",tableName,tem.stdID,tem.examID , tem.stdGrade);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
}
