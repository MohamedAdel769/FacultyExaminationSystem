package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBListOfExamSessions {
    String StuID = null , examSessionsID = null;
    String tableName = "ListOfExamSessions";
    public DBListOfExamSessions getBySudentId(String id) {
        startConnection();
        DBListOfExamSessions tem = new DBListOfExamSessions();
        try {
            String query = String.format("select * from %s where StuID = %s",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.examSessionsID = dBResult.getString("examSessionsID");
                tem.StuID = dBResult.getString("StuID");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }
        return tem;
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
