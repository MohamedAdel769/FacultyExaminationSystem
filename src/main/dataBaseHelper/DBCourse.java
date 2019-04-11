package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.OK;

public class DBCourse {
    String courseID = null;
    String Name = null;
    String Department = null;
    String instrID = null;
    final String tableName = "Course";
    public DBCourse getById(String id) {
        startConnection();
        DBCourse tem = new DBCourse();
        try {
            String query = String.format("select * from %s where courseID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.courseID = dBResult.getString("courseID");
                tem.Name = dBResult.getString("Name");
                tem.Department = dBResult.getString("Department");
                tem.instrID = dBResult.getString("instrID");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return tem;
    }
    public int add(DBCourse tem) {
        try {
            startConnection();
            String s = "";
            String query = String.format("insert into %s (courseID, Name, Department, instrID)" +
                            "values ('%s','%s','%s','%s')",tableName,tem.courseID,tem.Name,tem.Department
                    ,tem.instrID);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
}
