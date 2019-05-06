package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.OK;

public class DBCourse {
    public String courseID = null;
    public String Name = null;
    public String Department = null;
    public String instrID = null;

    final String tableName = "Course";

    public DBCourse(String courseID, String name, String department, String instrID) {
        this.courseID = courseID;
        Name = name;
        Department = department;
        this.instrID = instrID;
    }

    public DBCourse() {
    }

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
    public Vector<DBCourse> getByInstrId(String id) {
        startConnection();
        DBCourse tem = new DBCourse();
        Vector<DBCourse> v = new Vector<>();
        try {
            String query = String.format("select * from %s where instrID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.courseID = dBResult.getString("courseID");
                tem.Name = dBResult.getString("Name");
                tem.Department = dBResult.getString("Department");
                tem.instrID = dBResult.getString("instrID");
                v.add(tem);
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return v;
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
