package com.example.cvapp2.hocvan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLHocVan extends SQLiteOpenHelper {
    private static final String DATA_MANAGER = "knowledge manager";
    private static final String TABLE_NAME = "knowledge";
    private static String ID = "id";
    private static String NAME = "school";
    private static String MAJOR = "major";
    private static String RANK = "rank";
    private Context context;
    private String TAG = "tag";
    public SQLHocVan(Context context) {
        super(context, DATA_MANAGER, null, 1);
        this.context =context;
    }

    String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            MAJOR + " TEXT, " +
            RANK + " TEXT)";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);
        Log.d(TAG,"success");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addKnowledge(Knowledge knowledge ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,knowledge.getmNameSchool());
        contentValues.put(MAJOR, knowledge.getmMajor());
        contentValues.put(RANK,knowledge.getmRank());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    public Knowledge get(){
        Knowledge knowledge = new Knowledge();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "SELECT * FROM " +TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToLast()){
            knowledge.setmNameSchool(cursor.getString(1));
            knowledge.setmMajor(cursor.getString(2));
            knowledge.setmRank(cursor.getString(3));
        }
        cursor.close();
        sqLiteDatabase.close();
        return knowledge;
    }

    public int updateKnowledge(Knowledge knowledge){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,knowledge.getmNameSchool());
        contentValues.put(MAJOR, knowledge.getmMajor());
        contentValues.put(RANK,knowledge.getmRank());

        return sqLiteDatabase.update(TABLE_NAME,contentValues,ID + "=?",new String[]{String.valueOf(knowledge.getId())});
    }

    public int delete(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,null,null);
    }
}
