package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBExam {
    String examId = null;
    String courseId= null;
    String  durationTime= null;
    boolean acceptStatus;
    String releaseData= null;
    String instructorId= null;
    int totalGrade;

    public DBExam() {
    }

    public DBExam(String examId, String courseId, String durationTime, boolean acceptStatus, String releaseData, String instructorId, int totalGrade) {
        this.examId = examId;
        this.courseId = courseId;
        this.durationTime = durationTime;
        this.acceptStatus = acceptStatus;
        this.releaseData = releaseData;
        this.instructorId = instructorId;
        this.totalGrade = totalGrade;
    }

    public DBExam getById(String id) {
        startConnection();
        DBExam dbExam = new DBExam();
        try {
            String query = String.format("select * from Exam where examID = %s", id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                dbExam.examId = dBResult.getString("examID");
                dbExam.courseId = dBResult.getString("courseId");
                dbExam.durationTime = dBResult.getString("durationTime");
                dbExam.acceptStatus = dBResult.getBoolean("acceptStatus");
                dbExam.releaseData = dBResult.getString("releaseDate");
                dbExam.instructorId = dBResult.getString("instructorId");
                dbExam.totalGrade = dBResult.getInt("totalGrade");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName());
        }
        close();
        return dbExam;
    }

    public int add(DBExam exam) {
        startConnection();
        try {
            if(getById(exam.examId).examId != null){
                return ALREADY_EXIST;
            }
            String query = String.format("insert into Exam  (examId,courseId, durationTime, acceptStatus, releaseDate, instructorId, totalGrade)" +
                    "values ('%s','%s','%s',%b,'%s','%s',%d)",exam.examId, exam.courseId, exam.durationTime, exam.acceptStatus, exam.releaseData, exam.instructorId, exam.totalGrade);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName());
        }finally {
            close();
        }
        return OK;
    }
    public void uodate(DBExam exam){
        startConnection();
        try {
            if(getById(exam.examId).examId == null){
                //return NOT_FOUNDED;
            }
            String query = String.format("insert into Exam  (examId,courseId, durationTime, acceptStatus, releaseDate, instructorId, totalGrade)" +
                    "values ('%s','%s','%s',%b,'%s','%s',%d)",exam.examId, exam.courseId, exam.durationTime, exam.acceptStatus, exam.releaseData, exam.instructorId, exam.totalGrade);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName());
        }finally {
            close();
        }
    }
}
