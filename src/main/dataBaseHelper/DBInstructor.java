package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBInstructor {
    String instrID = null;
    String Name = null;
    String Phone = null;
    String Email = null;
    String Age = null;
    final String tableName = "Instructor";

    public DBInstructor(String stdID, String name, String phone, String email,String Age ) {
        this.instrID = stdID;
        Name = name;
        Phone = phone;
        this.Email = email;
        this.Age = Age;
    }

    public DBInstructor() {
    }

    public DBInstructor getById(String id) {
        startConnection();
        DBInstructor tem = new DBInstructor();
        try {
            String query = String.format("select * from %s where instrID = '%s' ",tableName, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.instrID = dBResult.getString("instrID");
                tem.Name = dBResult.getString("Name");
                tem.Phone = dBResult.getString("Phone");
                tem.Email = dBResult.getString("Email");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }
        return tem;
    }
    public int add(DBInstructor tem) {
        try {
            startConnection();
            String s = "";
            String query = String.format("insert into %s (instrID, Name, Phone, Email , AGE)" +
                            "values ('%s','%s','%s','%s')",tableName,tem.instrID,tem.Name,tem.Phone
                    ,tem.Email);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
        return OK;
    }
    public int update(DBInstructor tem){
        try {
            if(getById(tem.instrID).instrID == null){
                return NOT_FOUNDED;
            }
            startConnection();
            String query = String.format("update %s set\n" +
                            " Name = '%s', Phone = '%s', Email = '%s' , Age = '%s' where instrID = '%s'",
                    tableName,tem.Name , tem.Phone , tem.Email , tem.Age , tem.instrID);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return OK;
    }

}
