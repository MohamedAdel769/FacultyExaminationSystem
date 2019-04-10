package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.dBResult;

public class DBExaminationSession {
    String examSessionsID = null , examID = null;
    String tableName = "ExaminationSession";
    public DBExaminationSession getById(String id) {
        startConnection();
        DBExaminationSession tem = new DBExaminationSession();
        try {
            String query = String.format("select * from %s where examSessionsID = %s",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.examID = dBResult.getString("examID");
                tem.examSessionsID = dBResult.getString("examSessionsID");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return tem;
    }
    public int add(DBExaminationSession tem) {
        try {
            if(getById(tem.examSessionsID).examSessionsID != null){
                return ALREADY_EXIST;
            }
            startConnection();
            String query = String.format("insert into %s (examSessionsID , examID )" +
                    "values ('%s','%s')",tableName,tem.examSessionsID,tem.examID);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
}