package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBHelper {


    // TODO DBQustion helper

    public void test(int id) {
        System.out.println(new DBStudent());
        System.out.println(new DBStudent().getByUsername("55").Phone);
    }
}
