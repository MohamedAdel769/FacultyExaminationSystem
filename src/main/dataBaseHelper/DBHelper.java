package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBHelper {


    public void test(int id) {
        System.out.println(new DBExam().add(new DBExam("id","id2",TIME_TEST,true,DATE_TEST,"ds",5,TIME_TEST,TIME_TEST)));
    }
}
