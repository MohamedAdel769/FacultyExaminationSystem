package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBListOfGrades {
    String stdID = null;
    String examID = null;
    int stdGrade = 0;
    int ExamGrade = 0 ;
    String Course_name=null;
    final String tableName = "ListOfGrades";
    // function btgeeb grades & evaluation rank lel 5 hardest
    public DBListOfGrades(String stdID, String examID, int stdGrade,int examGrade,String course_name) {
        this.stdID = stdID;
        this.examID = examID;
        this.stdGrade = stdGrade;
        this.ExamGrade= examGrade;
        this.Course_name = course_name;
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
                tem.ExamGrade = dBResult.getInt("ExamGrade");
                tem.Course_name = dBResult.getString("Course_Name");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return tem;
    }
    public int add(DBListOfGrades tem) {
        try {
            startConnection();
            String query = String.format("insert into %s (stdID , examID , stdGrade,ExamGrade,Course_Name  )" +
                    "values ('%s','%s' , %d,%d,'%s') ",tableName,tem.stdID,tem.examID , tem.stdGrade, tem.ExamGrade,tem.Course_name );
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
}
