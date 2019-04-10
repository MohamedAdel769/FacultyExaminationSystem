package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.dBResult;

public class DBAnnouncement {
    String announID = null, instructorID= null, examID= null, msgBody= null, msgHead= null;
    String tableName = "Announcement";
    String tableId = "announID";

    public DBAnnouncement() {
    }

    public DBAnnouncement(String announID, String instructorID, String examID, String msgBody, String msgHead, String tableName, String tableId) {
        this.announID = announID;
        this.instructorID = instructorID;
        this.examID = examID;
        this.msgBody = msgBody;
        this.msgHead = msgHead;
        this.tableName = tableName;
        this.tableId = tableId;
    }

    public DBAnnouncement getById(String id) {
        startConnection();
        DBAnnouncement announcement = new DBAnnouncement();
        try {
            String query = String.format("select * from %s where announID = %s",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                announcement.announID = dBResult.getString("announID");
                announcement.instructorID = dBResult.getString("instructorID");
                announcement.examID = dBResult.getString("examID");
                announcement.msgBody = dBResult.getString("msgBody");
                announcement.msgHead = dBResult.getString("msgHead");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }
        return announcement;
    }

    public int deleteById(String id){
        try {
            if(getById(id).announID == null){
                return NOT_FOUNDED;
            }
            startConnection();
            String query = String.format("DELETE FROM %s where %s = '%s'",tableName,tableId,id);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
    public int add(DBAnnouncement ann) {
        try {
            if(getById(ann.announID).announID != null){
                return ALREADY_EXIST;
            }
            startConnection();
            String query = String.format("insert into %s (announID, instructorID, examID, msgBody, msgHead)" +
                    "values ('%s','%s','%s','%s','%s')",tableName,ann.announID,ann.instructorID,ann.examID,ann.msgBody,ann.msgHead);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("add error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }

}