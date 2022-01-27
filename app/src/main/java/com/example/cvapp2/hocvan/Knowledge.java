package com.example.cvapp2.hocvan;

public class Knowledge {
    private int id;
    private String mNameSchool;
    private String mMajor;
    private String mRank;

    public Knowledge() {
    }

    public Knowledge(String mNameSchool, String mMajor, String mRank) {
        this.mNameSchool = mNameSchool;
        this.mMajor = mMajor;
        this.mRank = mRank;
    }

    public Knowledge(int id, String mNameSchool, String mMajor, String mRank) {
        this.id = id;
        this.mNameSchool = mNameSchool;
        this.mMajor = mMajor;
        this.mRank = mRank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmNameSchool() {
        return mNameSchool;
    }

    public void setmNameSchool(String mNameSchool) {
        this.mNameSchool = mNameSchool;
    }

    public String getmMajor() {
        return mMajor;
    }

    public void setmMajor(String mMajor) {
        this.mMajor = mMajor;
    }

    public String getmRank() {
        return mRank;
    }

    public void setmRank(String mRank) {
        this.mRank = mRank;
    }
}
