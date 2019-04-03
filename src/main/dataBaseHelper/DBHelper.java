package main.dataBaseHelper;
import java.sql.Date;
import java.sql.SQLException;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBHelper {

    public class DBExam {
        String  examId;
        String courseId;
        Date durationTime;
        boolean acceptStatus;
        Date releaseData;
        String instructorId;
        int totalGrade;
    }
    public class DBAnnouncement {
        String announID,instructorID,examID,msgBody,msgHead;
    }
    public class DBHistogram{
        String histoID,examID;
    }
    public class DBListOfGrades{
        String stdID,examID;
        int stdGrade;
    }

    //Exam
    public DBExam getExamById(String  id) {
        startConnection();
        DBExam dbExam = new DBExam();
        try {
            String query = String.format("select * from Exam where examID = %s", id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                dbExam.examId = dBResult.getString("examID");
                dbExam.courseId = dBResult.getString("courseId");
                dbExam.durationTime = dBResult.getDate("durationTime");
                dbExam.acceptStatus = dBResult.getBoolean("acceptStatus");
                dbExam.releaseData = dBResult.getDate("releaseDate");
                dbExam.instructorId = dBResult.getString("instructorId");
                dbExam.totalGrade = dBResult.getInt("totalGrade");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName());
        }
        return dbExam;
    }

    public DBAnnouncement getAnnouncementById(String  id) {
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

    public void test(int id){

    }
}
