package main.dataBaseHelper;

import java.sql.*;

public class dataBaseConVars {
    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet dBResult = null;
    public static String host = "remotemysql.com";
    public static String dataBaseName = "AVDNGnJD07";
    public static String username = "AVDNGnJD07";
    public static String pass = "VvRVwiy13X";
    public static int ALREADY_EXIST = 202;
    public static int OK = 1;
    public static int NOT_FOUNDED = 404;
    /**
     * start database connection
     */
    public static void startConnection(){
        try {
            String url = String.format("jdbc:mysql://%s/%s",host,dataBaseName);
            conn = DriverManager.getConnection(url,username,pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("connection error");
        }
    }
    /**
     * close database connection
     */
    public static void close(){
        if (dBResult != null) {
            try {
                dBResult.close();
            } catch (SQLException sqlEx) { } // ignore
            dBResult = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore
            stmt = null;
        }
    }
}
