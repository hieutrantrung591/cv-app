package com.example.cvapp2.thongtin;

public class Info {
    private String mId;
    private String mName;
    private String mWork;
    private String mEmail;
    private String mAddress;
    private String mPhone;
    private String mBirthday;
    private String mSex;

    public Info() {
    }

    public Info(String mName, String mWork, String mEmail, String mAddress, String mPhone, String mBirthday, String mSex) {
        this.mName = mName;
        this.mWork = mWork;
        this.mEmail = mEmail;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
        this.mBirthday = mBirthday;
        this.mSex = mSex;
    }

    public Info(String mId, String mName, String mWork, String mEmail, String mAddress, String mPhone, String mBirthday, String mSex) {
        this.mId = mId;
        this.mName = mName;
        this.mWork = mWork;
        this.mEmail = mEmail;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
        this.mBirthday = mBirthday;
        this.mSex = mSex;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmWork() {
        return mWork;
    }

    public void setmWork(String mWork) {
        this.mWork = mWork;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmBirthday() {
        return mBirthday;
    }

    public void setmBirthday(String mBirthday) {
        this.mBirthday = mBirthday;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }
}
