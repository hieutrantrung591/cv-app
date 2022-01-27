package com.example.cvapp2.skillsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SQLSkill extends SQLiteOpenHelper {
    private static final String DATA_MANAGER = "skill_manager";
    private static final String TABLE_NAME = "skill";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String MAX = "max";
    private static final String PROGRESS = "progress";
    private Context context;
    private final String TAG = "tag";

    public SQLSkill(Context context) {
        super(context, DATA_MANAGER, null,1);
        this.context = context;

    }

    String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            MAX + " integer, " +
           PROGRESS + " integer)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlQuery);
        Log.d(TAG,"on create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addSkill(Skill skill){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,skill.getName());
//        contentValues.put(MAX,skill.getMaxSeekbar());
        contentValues.put(PROGRESS,skill.getProgressSeekbar());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public ArrayList<Skill> get(){
        ArrayList<Skill> skills = new ArrayList<>();
        String sql = "SELECT * FROM " +TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Skill skill = new Skill();
                skill.setId(cursor.getInt(0));
                skill.setName(cursor.getString(1));
                skill.setProgressSeekbar(cursor.getInt(3));

                skills.add(skill);
            }while (cursor.moveToNext());
            cursor.close();
            sqLiteDatabase.close();
        }

        return skills;
    }

    public int updateSkill(Skill skill){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,skill.getName());
//        contentValues.put(MAX, skill.getMaxSeekbar());
        contentValues.put(PROGRESS, skill.getProgressSeekbar());

        return  sqLiteDatabase.update(TABLE_NAME,contentValues,ID + "=?",new String[]{String.valueOf(skill.getId())});
    }

    public int deleteSkill(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,ID + "=?",new String[]{String.valueOf(id)});
    }

    public int deleteAll(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,null,null);
    }
}
