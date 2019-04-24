package main.dataBaseHelper;

import main.Users.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.dBResult;

public class DBStudent {
    String stdID = null;
    String Name = null;
    String Phone = null;
    String email = null;
    String Username = null;
    String Password = null;
    final String tableName = "Student";

    public DBStudent(String stdID, String name, String phone, String email,String Username , String Password) {
        this.stdID = stdID;
        Name = name;
        Phone = phone;
        this.email = email;
        this.Username =username;
        this.Password=Password;
    }

    public DBStudent() {
    }

    public DBStudent getById(String id) {
        startConnection();
        DBStudent tem = new DBStudent();
        try {
            String query = String.format("select * from %s where stdID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.stdID = dBResult.getString("stdID");
                tem.Name = dBResult.getString("Name");
                tem.Phone = dBResult.getString("Phone");
                tem.email = dBResult.getString("Email");
                tem.Username = dBResult.getString("Username");
                tem.Password = dBResult.getString("Password");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return tem;
    }
    public int add(DBStudent tem) {
        try {
            startConnection();
            String s = "";
            String query = String.format("insert into %s (stdID, Name, Phone, Email, Username, Password)" +
                            "values ('%s','%s','%s','%s','%s','%s')",tableName,tem.stdID,tem.Name,tem.Phone
                    ,tem.email,tem.Username,tem.Password);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
    public int update(DBStudent tem){
        try {
            if(getById(tem.stdID).stdID == null){
                return NOT_FOUNDED;
            }
            startConnection();
            String query = String.format("update %s set\n" +
                    " Name = '%s', Phone = '%s', email = '%s' , Username = '%s' , Password = '%s' where stdID = '%s'",
                    tableName,tem.Name , tem.Phone , tem.email , tem.Username , tem.Password , tem.stdID);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return OK;
    }

    /**
     *
     * @param name the name of the dataBase atr
     * @param value the vale of the atr
     * @return ArrayList of the all founded students
     */
    public ArrayList<DBStudent> getAllWhere(String name , String value){
        ArrayList<DBStudent> res = new ArrayList<>();
        startConnection();
        try {
            String query = String.format("select * from %s where %s = '%s' ",tableName, name , value);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                DBStudent tem = new DBStudent();
                tem.stdID = dBResult.getString("stdID");
                tem.Name = dBResult.getString("Name");
                tem.Phone = dBResult.getString("Phone");
                tem.email = dBResult.getString("Email");
                tem.Username = dBResult.getString("Username");
                tem.Password = dBResult.getString("Password");
                res.add(tem);
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return res;
    }
}
