package main.GUI;

import javafx.beans.property.SimpleStringProperty;

public class tableData {
    public SimpleStringProperty fff, sss;

    public String getFff() {
        return fff.get();
    }

    public SimpleStringProperty fffProperty() {
        return fff;
    }

    public void setFff(String fff) {
        this.fff.set(fff);
    }

    public String getSss() {
        return sss.get();
    }

    public SimpleStringProperty sssProperty() {
        return sss;
    }

    public void setSss(String sss) {
        this.sss.set(sss);
    }
}