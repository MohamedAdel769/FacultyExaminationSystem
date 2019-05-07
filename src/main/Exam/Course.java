package main.Exam;

import main.dataBaseHelper.DBCourse;

public class Course implements getFromDB {

    private String ID,Name,DepName,InstructorID;

    public Course(String ID, String Name, String DepName, String InstructorID) {
        this.ID = ID;
        this.Name = Name;
        this.DepName = DepName;
        this.InstructorID = InstructorID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDepName() {
        return DepName;
    }

    public void setDepName(String DepName) {
        this.DepName = DepName;
    }

    public String getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(String InstructorID) {
        this.InstructorID = InstructorID;
    }

    @Override
    public void getFromDbByid(String id) {
        DBCourse dbCourse = new DBCourse().getById(id);
        this.ID = dbCourse.courseID;
        this.Name = dbCourse.Name;
        this.DepName = dbCourse.Department;
        this.InstructorID = dbCourse.instrID;
    }
}
