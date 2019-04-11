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
    int totalGrade = 0;
    String handlingTimer  = null;
    String accepTimer = null;

    final String tableName = "Exam";
    final String tableId = "examId";
    public DBExam() {
    }

    public DBExam(String examId, String courseId, String durationTime, boolean acceptStatus, String releaseData, String instructorId, int totalGrade, String handlingTimer, String accepTimer) {
        this.examId = examId;
        this.courseId = courseId;
        this.durationTime = durationTime;
        this.acceptStatus = acceptStatus;
        this.releaseData = releaseData;
        this.instructorId = instructorId;
        this.totalGrade = totalGrade;
        this.handlingTimer = handlingTimer;
        this.accepTimer = accepTimer;
    }

    public DBExam getById(String id) {
        startConnection();
        DBExam dbExam = new DBExam();
        try {
            String query = String.format("select * from %s where %s = '%s'",tableName,tableId, id);
            dBResult = stmt.executeQuery(query);
            while (dBResult.next()) {
                dbExam.examId = dBResult.getString("examId");
                dbExam.courseId = dBResult.getString("courseId");
                dbExam.durationTime = dBResult.getString("durationTime");
                dbExam.acceptStatus = dBResult.getBoolean("acceptStatus");
                dbExam.releaseData = dBResult.getString("releaseDate");
                dbExam.instructorId = dBResult.getString("instructorId");
                dbExam.totalGrade = dBResult.getInt("totalGrade");
                dbExam.handlingTimer = dBResult.getString("handlingTimer");
                dbExam.accepTimer = dBResult.getString("accepTimer");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }
        close();
        return dbExam;
    }

    public int deleteById(String id){
        try {
            if(getById(id).examId == null){
                return NOT_FOUNDED;
            }
            startConnection();
            String query = String.format("DELETE FROM %s where %s = '%s'",tableName,tableId,id);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return OK;
    }

    public int add(DBExam exam) {
        try {
            if(getById(exam.examId).examId != null){
                return ALREADY_EXIST;
            }
            startConnection();
            String query = String.format("insert into %s  (examId,courseId, durationTime, acceptStatus, releaseDate, instructorId, totalGrade , handlingTimer , accepTimer)" +
                    "values ('%s','%s','%s',%b,'%s','%s',%d,'%s','%s')",tableName,exam.examId, exam.courseId, exam.durationTime, exam.acceptStatus, exam.releaseData, exam.instructorId, exam.totalGrade , exam.handlingTimer , exam.accepTimer);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + "  " + ex);
        }finally {
            close();
        }
        return OK;
    }

    public int update(DBExam exam){
        try {
            if(getById(exam.examId).examId == null){
                return NOT_FOUNDED;
            }
            startConnection();
            String query = String.format("update %s set\n" +
                    "courseId = '%s', durationTime = '%s', acceptStatus = %b, releaseDate = '%s', instructorId = '%s', totalGrade = %d , handlingTimer = '%s' , accepTimer = '%s'  where examId = '%s'",tableName,exam.courseId, exam.durationTime, exam.acceptStatus, exam.releaseData, exam.instructorId, exam.totalGrade,exam.examId,exam.handlingTimer , exam.accepTimer);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return OK;
    }

}
