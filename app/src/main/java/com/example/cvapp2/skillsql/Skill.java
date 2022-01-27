package com.example.cvapp2.skillsql;

public class Skill {
    private int id;
    private String name;
    private int maxSeekbar;
    private int progressSeekbar;

    public Skill(String name, int maxSeekbar, int progressSeekbar) {
        this.name = name;
        this.maxSeekbar = maxSeekbar;
        this.progressSeekbar = progressSeekbar;
    }

    public Skill() {
    }

    public Skill(int id, String name, int maxSeekbar, int progressSeekbar) {
        this.id = id;
        this.name = name;
        this.maxSeekbar = maxSeekbar;
        this.progressSeekbar = progressSeekbar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSeekbar() {
        return 10;
    }

    public void setMaxSeekbar() {
        this.maxSeekbar = 10;
    }

    public int getProgressSeekbar() {
        return progressSeekbar;
    }

    public void setProgressSeekbar(int progressSeekbar) {
        this.progressSeekbar = progressSeekbar;
    }




}
