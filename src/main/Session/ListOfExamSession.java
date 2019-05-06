package main.Session;

import javafx.beans.property.SimpleStringProperty;

public class ListOfExamSession {
    public SimpleStringProperty StuID  , examSessionsID;

    public ListOfExamSession(String stuID, String examSessionsID) {
        this.StuID = new SimpleStringProperty(stuID);
        this.examSessionsID = new SimpleStringProperty(examSessionsID);
    }

    public String getStuID() {
        return StuID.get();
    }

    public SimpleStringProperty stuIDProperty() {
        return StuID;
    }

    public void setStuID(String stuID) {
        this.StuID.set(stuID);
    }

    public String getExamSessionsID() {
        return examSessionsID.get();
    }

    public SimpleStringProperty examSessionsIDProperty() {
        return examSessionsID;
    }

    public void setExamSessionsID(String examSessionsID) {
        this.examSessionsID.set(examSessionsID);
    }
}
