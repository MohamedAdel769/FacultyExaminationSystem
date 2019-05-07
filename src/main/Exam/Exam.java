package main.Exam;

public class Exam {
    private String Id = null;
    private String courseId= null;
    private String  durationTime= null;
    private boolean acceptStatus;
    private String releaseData= null;
    private String instructorId= null;
    private int totalGrade = 0;
    private String handlingTimer  = null;
    private String accepTimer = null;

    public Exam(String id, String courseId, String durationTime, boolean acceptStatus, String releaseData, String instructorId, int totalGrade, String handlingTimer, String accepTimer) {
        Id = id;
        this.courseId = courseId;
        this.durationTime = durationTime;
        this.acceptStatus = acceptStatus;
        this.releaseData = releaseData;
        this.instructorId = instructorId;
        this.totalGrade = totalGrade;
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
}
