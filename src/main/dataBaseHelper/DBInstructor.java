package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBInstructor {
    public String Name = null;
    public String Phone = null;
    public String Email = null;
    public String Age = null;
    public String Username = null;
    public String Password = null;
    final String tableName = "Instructor";

    public DBInstructor( String name, String phone, String email,String Age , String Username , String Password) {
        Name = name;
        Phone = phone;
        this.Email = email;
        this.Age = Age;
        this.Username = Username;
        this.Password = Password;
    }

    public DBInstructor() {
    }

    public DBInstructor getByUsername(String Username) {
        startConnection();
        DBInstructor tem = new DBInstructor();
        try {
            String query = String.format("select * from %s where Username = '%s' ",tableName, Username);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                tem.Name = dBResult.getString("Name");
                tem.Phone = dBResult.getString("Phone");
                tem.Email = dBResult.getString("Email");
                tem.Age = dBResult.getString("Age");
                tem.Username = dBResult.getString("Username");
                tem.Password = dBResult.getString("Password");
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
            String query = String.format("insert into %s (Name, Phone, Email , AGE, Username, Password)" +
                            "values ('%s','%s','%s','%s','%s','%s')",tableName,tem.Name,tem.Phone
                    ,tem.Email,tem.Age,tem.Username,tem.Password);
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
            if(getByUsername(tem.Username).Username == null){
                return NOT_FOUNDED;
            }
            startConnection();
            String query = String.format("update %s set\n" +
                            " Name = '%s', Phone = '%s', Email = '%s' , Age = '%s' , Password = '%s' where Username = '%s'",
                    tableName,tem.Name , tem.Phone , tem.Email , tem.Age , tem.Password , tem.Username);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return OK;
    }

}