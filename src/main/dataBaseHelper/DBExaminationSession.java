package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.dBResult;

public class DBExaminationSession {
    public String examSessionsID = null , examID = null;
    final String tableName = "ExaminationSession";

    public DBExaminationSession(String examSessionsID, String examID) {
        this.examSessionsID = examSessionsID;
        this.examID = examID;
    }

    public DBExaminationSession() {

    }

    public DBExaminationSession getById(String id) {
        startConnection();
        DBExaminationSession tem = new DBExaminationSession();
        try {
            String query = String.format("select * from %s where examSessionsID = '%s' ",tableName, id);
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

    public ArrayList<DBExaminationSession> getAll() {
        startConnection();
        ArrayList<DBExaminationSession> v = new ArrayList<>();
        try {
            String query = String.format("select * from %s",tableName);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                DBExaminationSession tem = new DBExaminationSession();
                tem.examID = dBResult.getString("examID");
                tem.examSessionsID = dBResult.getString("examSessionsID");
                v.add(tem);
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return v;
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
