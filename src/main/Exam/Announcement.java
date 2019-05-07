package main.Exam;

import main.dataBaseHelper.DBAnnouncement;

public class Announcement {
    private String id;
    private String instructorId;
    private String headOfAnnoun;
    private String bodyOfAnnoun;

    public Announcement(String id, String instructorId, String headOfAnnoun, String bodyOfAnnoun) {
        this.id = id;
        this.instructorId = instructorId;
        this.headOfAnnoun = headOfAnnoun;
        this.bodyOfAnnoun = bodyOfAnnoun;
    }
    public Announcement(DBAnnouncement a){
        id = a.getAnnounID();
        instructorId = a.getInstructorID();
        headOfAnnoun = a.getMsgHead();
        bodyOfAnnoun = a.getMsgBody();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getHeadOfAnnoun() {
        return headOfAnnoun;
    }

    public void setHeadOfAnnoun(String headOfAnnoun) {
        this.headOfAnnoun = headOfAnnoun;
    }

    public String getBodyOfAnnoun() {
        return bodyOfAnnoun;
    }

    public void setBodyOfAnnoun(String bodyOfAnnoun) {
        this.bodyOfAnnoun = bodyOfAnnoun;
    }
}
