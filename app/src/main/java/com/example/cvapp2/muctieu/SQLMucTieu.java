package com.example.cvapp2.muctieu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLMucTieu extends SQLiteOpenHelper {
    private static final String DATA_MANAGER = "goals manager";
    private static final String TABLE_NAME = "goals";
    private static final String ID = "id";
    private static final String GOALS = "goal";
    private Context context;
    public SQLMucTieu(Context context) {
        super(context, DATA_MANAGER, null, 1);
        this.context =context;
    }

    String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            GOALS + " TEXT)";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addGoals(Goals goals){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GOALS,goals.getmGoals());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public Goals get(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Goals goals = new Goals();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToLast()){
            goals.setmGoals(cursor.getString(1));
            cursor.close();
            sqLiteDatabase.close();
        }

        return goals;
    }

    public int deleteGoals(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,null,null);
    }
}
