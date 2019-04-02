package main.dataBaseHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseConVars {
    public String host = "";
    public String dataBaseName = "";
    public String username = "";
    public String pass = "";
    public void f(){
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?user=minty&password=greatsqldb");
    }

}
