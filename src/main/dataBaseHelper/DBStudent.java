package main.dataBaseHelper;

import main.Users.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static main.dataBaseHelper.dataBaseConVars.*;
import static main.dataBaseHelper.dataBaseConVars.dBResult;

public class DBStudent {
    public String stdID = null;
    public String Name = null;
    public String Phone = null;
    public String email = null;
    public String Username = null;
    public String Password = null;
    final String tableName = "Student";

    public DBStudent(String stdID, String name, String phone, String email,String Username , String Password) {
        this.stdID = stdID;
        Name = name;
        Phone = phone;
        this.email = email;
        this.Username =Username;
        this.Password=Password;
    }

    public DBStudent() {
    }

    public DBStudent getByUsername(String Username) {
        startConnection();
        DBStudent tem = new DBStudent();
        try {
            String query = String.format("select * from %s where Username = '%s' ",tableName, Username);
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
        }finally {
            close();
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
            if(getByUsername(tem.Username).Username == null){
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
        }finally {
            close();
        }
        return res;
    }
}
