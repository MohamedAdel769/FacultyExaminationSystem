package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBHelper {


    public class DBAnnouncement {
        String announID, instructorID, examID, msgBody, msgHead;
        public DBAnnouncement getAnnouncementById(String id) {
            startConnection();
            DBAnnouncement announcement = new DBAnnouncement();
            try {
                String query = String.format("select * from DBAnnouncement where announID = %s", id);
                dBResult = stmt.executeQuery(query);
                while (dBResult.next()) {
                    announcement.announID = dBResult.getString("announID");
                    announcement.instructorID = dBResult.getString("instructorID");
                    announcement.examID = dBResult.getString("examID");
                    announcement.msgBody = dBResult.getString("msgBody");
                    announcement.msgHead = dBResult.getString("msgHead");
                }
            } catch (SQLException ex) {
                System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName());
            }
            return announcement;
        }
    }

    public class DBHistogram {
        String histoID, examID;
    }

    public class DBListOfGrades {
        String stdID, examID;
        int stdGrade;
    }



    public void test(int id) {
        new DBExam().add(new DBExam("555","5","05:00:00",true,"5-5-5","5",5));
    }
}
