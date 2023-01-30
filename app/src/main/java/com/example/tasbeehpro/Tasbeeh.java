package com.example.tasbeehpro;

import java.util.Date;

public class Tasbeeh {
    int id;
    String tasbeehName;
    String isRecited;
    int noOfCount;
    Date date;

    public Tasbeeh() {
        this.tasbeehName = "";
        this.isRecited = "";
        this.noOfCount = 0;
    }

    public Tasbeeh(String tasbeehName, String isRecited, int noOfCount) {
        this.tasbeehName = tasbeehName;
        this.isRecited = isRecited;
        this.noOfCount = noOfCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTasbeehName() {
        return tasbeehName;
    }

    public void setTasbeehName(String tasbeehName) {
        this.tasbeehName = tasbeehName;
    }

    public String getIsRecited() {
        return isRecited;
    }

    public void setIsRecited(String isRecited) {
        this.isRecited = isRecited;
    }

    public int getNoOfCount() {
        return noOfCount;
    }

    public void setNoOfCount(int noOfCount) {
        this.noOfCount = noOfCount;
    }

    @Override
    public String toString() {
        return "Tasbeeh{" +
                "id=" + id +
                ", tasbeehName='" + tasbeehName + '\'' +
                ", isRecited='" + isRecited + '\'' +
                ", noOfCount=" + noOfCount +
                '}';
    }
}