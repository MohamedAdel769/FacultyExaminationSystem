package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBHelper {




    public class DBHistogram {
        String histoID, examID;
    }

    public class DBListOfGrades {
        String stdID, examID;
        int stdGrade;
    }



    public void test(int id) {
        int x = new DBExam().add(new DBExam("55sdvsdv5","600","60:00:00",false,"5-5-5","5",500));
        System.out.println(x);
    }
}
