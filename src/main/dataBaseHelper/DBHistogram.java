package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBHistogram {
    String histoID = null , examID = null;
    final String tableName = "Histogram";

    public DBHistogram(String histoID, String examID) {
        this.histoID = histoID;
        this.examID = examID;
    }

    public DBHistogram() {

    }

    public DBHistogram getById(String id) {
        startConnection();
        DBHistogram tem = new DBHistogram();
        try {
            String query = String.format("select * from %s where histoID = '%s'",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.examID = dBResult.getString("examID");
                tem.histoID = dBResult.getString("histoID");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }
        return tem;
    }
    public int add(DBHistogram tem) {
        try {
            if(getById(tem.histoID).histoID != null){
                return ALREADY_EXIST;
            }
            startConnection();
            String query = String.format("insert into %s (histoID , examID )" +
                    "values ('%s','%s')",tableName,tem.histoID,tem.examID);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return OK;
    }

    public String getHistoID() {
        return histoID;
    }

    public void setHistoID(String histoID) {
        this.histoID = histoID;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getTableName() {
        return tableName;
    }
}
