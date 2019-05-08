package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBListOfExamSessions {
    public String StuID = null , examSessionsID = null;
    final String tableName = "ListOfExamSessions";

    public DBListOfExamSessions(String stuID, String examSessionsID) {
        StuID = stuID;
        this.examSessionsID = examSessionsID;
    }

    public DBListOfExamSessions() {
    }

    public ArrayList<DBListOfExamSessions> getAllStudentsById(String id) {
        startConnection();
        ArrayList<DBListOfExamSessions> arr = new ArrayList<>();
        try {
            String query = String.format("select * from %s where examSessionsID = '%s'",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                DBListOfExamSessions tem = new DBListOfExamSessions();
                tem.examSessionsID = dBResult.getString("examSessionsID");
                tem.StuID = dBResult.getString("StuID");
                arr.add(tem);
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return arr;
    }

    public ArrayList<DBListOfExamSessions> getByStudentId(String id) {
        startConnection();
        ArrayList<DBListOfExamSessions> arr = new ArrayList<>();
        try {
            String query = String.format("select * from %s where StuID = '%s'",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                DBListOfExamSessions tem = new DBListOfExamSessions();
                tem.examSessionsID = dBResult.getString("examSessionsID");
                tem.StuID = dBResult.getString("StuID");
                arr.add(tem);
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return arr;
    }

    public int add(DBListOfExamSessions tem) {
        try {
            startConnection();
            String query = String.format("insert into %s (StuID , examSessionsID )" +
                    "values ('%s','%s')",tableName,tem.StuID,tem.examSessionsID);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return OK;
    }

}
