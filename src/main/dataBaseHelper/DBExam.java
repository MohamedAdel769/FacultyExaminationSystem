package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBExam {
    public String examId = null;
    public String courseId= null;
    public String  durationTime= null;
    public boolean acceptStatus;
    public String releaseData= null;
    public String instructorId= null;
    public int totalGrade = 0;
    public String handlingTimer  = null;
    public String accepTimer = null;
    public int num = 0;
    final String tableName = "Exam";
    final String tableId = "examId";
    public DBExam() {
    }

    /**
     *
     * @param examId
     * @param courseId
     * @param durationTime
     * @param acceptStatus
     * @param releaseData
     * @param instructorId
     * @param totalGrade
     * @param handlingTimer
     * @param accepTimer
     */
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

    public DBExam(String examId, String courseId, String durationTime, boolean acceptStatus, String releaseData, String instructorId, int totalGrade, String handlingTimer, String accepTimer, int num) {
        this.examId = examId;
        this.courseId = courseId;
        this.durationTime = durationTime;
        this.acceptStatus = acceptStatus;
        this.releaseData = releaseData;
        this.instructorId = instructorId;
        this.totalGrade = totalGrade;
        this.handlingTimer = handlingTimer;
        this.accepTimer = accepTimer;
        this.num = num;
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
                dbExam.num = dBResult.getInt("num");
            }
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName()+ " " + ex);
        }finally {
            close();
        }
        return dbExam;
    }


    public int add(DBExam exam) {
        try {
            if(getById(exam.examId).examId != null){
                return ALREADY_EXIST;
            }
            startConnection();
            String query = String.format("insert into %s  (examId,courseId, durationTime, acceptStatus, releaseDate, instructorId, totalGrade , handlingTimer , accepTimer , num)" +
                    "values ('%s','%s','%s',%b,'%s','%s',%d,'%s','%s' , %d)",tableName,exam.examId, exam.courseId, exam.durationTime, exam.acceptStatus, exam.releaseData, exam.instructorId, exam.totalGrade , exam.handlingTimer , exam.accepTimer ,exam.num);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + "  " + ex);
        }finally {
            close();
        }
        return OK;
    }
    public void pulsById(String id){
        try {
            startConnection();
            int x = new DBExam().getById(id).num +1;
            String query = String.format("update Exam set num = %d ",x);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex);
        }finally {
            close();
        }
    }
}
