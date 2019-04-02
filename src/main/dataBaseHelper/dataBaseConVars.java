package main.dataBaseHelper;

import main.PK.User;

import java.sql.*;

public class dataBaseConVars {
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;
    public String host = "remotemysql.com";
    public String dataBaseName = "AVDNGnJD07";
    public String username = "AVDNGnJD07";
    public String pass = "VvRVwiy13X";
    public void startConnection(){
        try {
            String url = String.format("jdbc:mysql://%s/%s",host,dataBaseName);
            conn = DriverManager.getConnection(url,username,pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("connection error");
        }
    }
    public void close(){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore

            stmt = null;
        }
    }
    public User getUser(int id){
        startConnection();
        User tem = new User();
        try {
            rs = stmt.executeQuery("select * from user");
            while(rs.next()){
                tem.id = rs.getInt("id");
                tem.name = rs.getString("name");
                if(id == tem.id);
                    break;
            }
        }
        catch (SQLException ex){
            System.out.println("query error");
        }
        finally {
            close();
        }
        return tem;
    }


}
