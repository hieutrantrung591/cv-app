package com.example.cvapp2.duan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SQLDuAn extends SQLiteOpenHelper {
    private static final String DATA_MANAGER = "project manager";
    private static final String TABLE_NAME = "project";
    private static final String COMPANY = "company";
    private static final String POSITION = "positionWork";
    private static final String ID = "id";
    private static final String DATE = "date";
    private static final String DESCRIBE = "describe";
    private final String TAG = "tag";
    private Context context;
    private final int VERSION1 = 1;

    String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            COMPANY + " TEXT, " +
            POSITION + " TEXT, " +
            DATE + " TEXT, " +
            DESCRIBE + " TEXT)";

    public SQLDuAn(Context context) {
        super(context, DATA_MANAGER, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);
        Log.d(TAG, "on create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addExperience(com.example.cvapp2.duan.Project project) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COMPANY, project.getCompany());
        contentValues.put(POSITION, project.getPositionWork());
        contentValues.put(DATE, project.getDate());
        contentValues.put(DESCRIBE, project.getDescribe());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public ArrayList<com.example.cvapp2.duan.Project> get() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ArrayList<com.example.cvapp2.duan.Project> projectArrayList = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                com.example.cvapp2.duan.Project project = new com.example.cvapp2.duan.Project();
                project.setId(cursor.getInt(0));
                project.setCompany(cursor.getString(1));
                project.setPositionWork(cursor.getString(2));
                project.setDate(cursor.getString(3));
                project.setDescribe(cursor.getString(4));

                projectArrayList.add(project);
            } while (cursor.moveToNext());
            cursor.close();
            sqLiteDatabase.close();
        }

        return projectArrayList;

    }

    public int updateExperience(com.example.cvapp2.duan.Project project) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COMPANY, project.getCompany());
        contentValues.put(POSITION, project.getPositionWork());
        contentValues.put(DATE, project.getDate());
        contentValues.put(DESCRIBE, project.getDescribe());

        return sqLiteDatabase.update(TABLE_NAME, contentValues, ID + "=?", new String[]{String.valueOf(project.getId())});
    }

    public int deleteExperience(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, ID + "=?", new String[]{String.valueOf(id)});
    }

    public int deleteAll(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,null,null);
    }
}
