package com.example.cvapp2.thongtin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLInfo extends SQLiteOpenHelper {
    private static final String DATA_MANAGER = "info manager";
    private static final  String TABLE_NAME = "info";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String WORK = "work";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String BIRTHDAY = "birthday";
    private static final String SEX = "sex";
    private Context context;
    private final String TAG = "tag";

    String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            WORK + " TEXT, " +
            EMAIL+ " TEXT, " +
            ADDRESS+ " TEXT, " +
            PHONE + " TEXT, " +
            BIRTHDAY + " TEXT, " +
            SEX + " TEXT)";

    public SQLInfo(Context context) {
        super(context, DATA_MANAGER, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addInfo(Info info){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,info.getmName());
        contentValues.put(WORK,info.getmWork());
        contentValues.put(EMAIL,info.getmEmail());
        contentValues.put(ADDRESS, info.getmAddress());
        contentValues.put(PHONE,info.getmPhone());
        contentValues.put(BIRTHDAY,info.getmBirthday());
        contentValues.put(SEX,info.getmSex());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    public Info get(){
        Info info = new Info();
        String sql = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToLast()){
            info.setmId(cursor.getString(0));
            info.setmName(cursor.getString(1));
            info.setmWork(cursor.getString(2));
            info.setmEmail(cursor.getString(3));
            info.setmAddress(cursor.getString(4));
            info.setmPhone(cursor.getString(5));
            info.setmBirthday(cursor.getString(6));
            info.setmSex(cursor.getString(7));
            cursor.close();
            sqLiteDatabase.close();
        }

        return info;
    }

    public int delete(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,null,null);
    }
}
