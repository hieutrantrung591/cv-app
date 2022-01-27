package com.example.cvapp2.sothich;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.cvapp2.muctieu.Goals;

public class SQLHobby extends SQLiteOpenHelper {
    private static final String DATA_MANAGER = "hobby manager";
    private static final String TABLE_NAME = "hobby";
    private static final String ID = "id";
    private static final String HOBBY = "hobby";
    private Context context;
    public SQLHobby(Context context) {
        super(context, DATA_MANAGER, null, 1);
        this.context = context;
    }
    String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            HOBBY + " TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addHobby(Hobby hobby){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HOBBY,hobby.getmHobby());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public Hobby get(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Hobby hobby= new Hobby();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToLast()){
            hobby.setmHobby(cursor.getString(1));
            cursor.close();
            sqLiteDatabase.close();
        }

        return hobby;
    }

    public int deleteHobby(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,null,null);
    }
}
