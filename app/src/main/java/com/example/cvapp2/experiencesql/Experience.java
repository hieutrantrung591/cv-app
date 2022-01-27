package com.example.cvapp2.experiencesql;

public class Experience {
    private String company;
    private String positionWork;
    private String date;
    private String describe;
    private int id;

    public Experience() {
    }

    public Experience(String company, String positionWork, String date, String describe, int id) {
        this.company = company;
        this.positionWork = positionWork;
        this.date = date;
        this.describe = describe;
        this.id = id;
    }

    public Experience(String company, String positionWork, String date, String describe) {
        this.company = company;
        this.positionWork = positionWork;
        this.date = date;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPositionWork() {
        return positionWork;
    }

    public void setPositionWork(String positionWork) {
        this.positionWork = positionWork;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescribe() {
        return describe;
    }

    public Experience(String company) {
        this.company = company;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
