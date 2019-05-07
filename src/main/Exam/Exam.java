package main.Exam;

import main.dataBaseHelper.DBExam;

public class Exam implements getFromDB{
    private String Id;
    private String courseId;
    private String  durationTime;
    private boolean acceptStatus;
    private String releaseData;
    private String instructorId;
    private int totalGrade;
    private String handlingTimer;
    private String accepTimer;

    public Exam(String id, String courseId, String durationTime, boolean acceptStatus, String releaseData, String instructorId, int totalGrade, String handlingTimer, String accepTimer) {
        Id = id;
        this.courseId = null;
        this.courseId = courseId;
        this.durationTime = null;
        this.durationTime = durationTime;
        this.acceptStatus = acceptStatus;
        this.releaseData = null;
        this.releaseData = releaseData;
        this.instructorId = null;
        this.instructorId = instructorId;
        this.totalGrade = 0;
        this.totalGrade = totalGrade;
        this.handlingTimer = null;
        this.handlingTimer = handlingTimer;
        this.accepTimer = accepTimer;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public boolean isAcceptStatus() {
        return acceptStatus;
    }

    public void setAcceptStatus(boolean acceptStatus) {
        this.acceptStatus = acceptStatus;
    }

    public String getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(String releaseData) {
        this.releaseData = releaseData;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public int getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(int totalGrade) {
        this.totalGrade = totalGrade;
    }

    public String getHandlingTimer() {
        return handlingTimer;
    }

    public void setHandlingTimer(String handlingTimer) {
        this.handlingTimer = handlingTimer;
    }

    public String getAccepTimer() {
        return accepTimer;
    }

    public void setAccepTimer(String accepTimer) {
        this.accepTimer = accepTimer;
    }

    @Override
    public void getFromDbByid(String id) {
        DBExam dbExam = new DBExam().getById(id);
        this.courseId = dbExam.courseId;
        this.durationTime = dbExam.durationTime;
        this.acceptStatus = dbExam.acceptStatus;
        this.releaseData = dbExam.releaseData;
        this.instructorId = dbExam.instructorId;
        this.totalGrade = dbExam.totalGrade;
        this.handlingTimer = dbExam.handlingTimer;
        this.accepTimer = dbExam.accepTimer;
    }
}
