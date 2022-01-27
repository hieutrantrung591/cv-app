package com.example.cvapp2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cvapp2.custom.CustomDA;
import com.example.cvapp2.custom.CustomHV;
import com.example.cvapp2.custom.CustomKHN;
import com.example.cvapp2.custom.CustomKN;
import com.example.cvapp2.custom.CustomMT;
import com.example.cvapp2.custom.CustomST;
import com.example.cvapp2.custom.CustomTT;
import com.example.cvapp2.duan.Project;
import com.example.cvapp2.duan.SQLDuAn;
import com.example.cvapp2.experiencesql.Experience;
import com.example.cvapp2.experiencesql.SQLExp;
import com.example.cvapp2.hocvan.Knowledge;
import com.example.cvapp2.hocvan.SQLHocVan;
import com.example.cvapp2.muctieu.Goals;
import com.example.cvapp2.muctieu.SQLMucTieu;
import com.example.cvapp2.skillsql.CustomLvSkill;
import com.example.cvapp2.skillsql.SQLSkill;
import com.example.cvapp2.skillsql.Skill;
import com.example.cvapp2.sothich.Hobby;
import com.example.cvapp2.sothich.SQLHobby;
import com.example.cvapp2.thongtin.Info;
import com.example.cvapp2.thongtin.SQLInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CV extends AppCompatActivity {
    Hobby hobby;
    Goals goals;
    Knowledge knowledge;
    Info info;

    ArrayList<Experience> experiences;
    ArrayList<Skill> skills;
    ArrayList<Project> projects;

    ListView lvHobby;
    ListView lvGoals;
    ListView lvKnowledge;
    ListView lvExp;
    ListView lvSkill;
    ListView lvProj;
    ListView lvThongTin;

     Bitmap bitmap, scalebmp;
     AppCompatActivity activity = CV.this;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cv_file);
        initWidget();
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        setLvExp();
        setLvGoals();
        setLvHobby();
        setLvKnowledge();
        setLvProj();
        setLvSkill();
        setLvThongTin();

    }

    public void initWidget(){
        lvExp  = findViewById(R.id.lvKinhnghiem);
        lvGoals = findViewById(R.id.lvMuctieu);
        lvHobby = findViewById(R.id.lvSothihc);
        lvKnowledge = findViewById(R.id.lvHocvan);
        lvProj = findViewById(R.id.lvDuan);
        lvSkill = findViewById(R.id.lvKinang);
        lvThongTin = findViewById(R.id.lvThongTin);
    }

    public void setLvHobby(){
        SQLHobby sqlHobby = new SQLHobby(this);
        hobby = sqlHobby.get();

        CustomST customST = new CustomST(CV.this,R.layout.sothich_view,hobby);
        lvHobby.setAdapter(customST);
    }

    public void setLvGoals(){
        SQLMucTieu sqlMucTieu = new SQLMucTieu(this);
        goals = sqlMucTieu.get();

        CustomMT customMT = new CustomMT(this,R.layout.muctieu_view,goals);
        lvGoals.setAdapter(customMT);
    }

    public void setLvKnowledge(){
        SQLHocVan sqlHocVan = new SQLHocVan(this);
        knowledge = sqlHocVan.get();

        CustomHV customHV = new CustomHV(this,R.layout.hovan_view,knowledge);
        lvKnowledge.setAdapter(customHV);
    }

    public void setLvExp(){
        SQLExp sqlExp = new SQLExp(this);
        experiences = sqlExp.get();

        CustomKHN customKHN = new CustomKHN(this, R.layout.kinhnghiem_view,experiences);
        lvExp.setAdapter(customKHN);
    }

    public void setLvProj(){
        SQLDuAn sqlDuAn = new SQLDuAn(this);
        projects = sqlDuAn.get();

        CustomDA customDA = new CustomDA(this,R.layout.duan_view,projects);
        lvProj.setAdapter(customDA);
    }

    public void  setLvSkill(){
        SQLSkill sqlSkill =  new SQLSkill(this);
        skills = sqlSkill.get();

        CustomKN customKN = new CustomKN(this,R.layout.kinang_view,skills);
        lvSkill.setAdapter(customKN);
    }

    public void setLvThongTin(){
        SQLInfo sqlInfo = new SQLInfo(this);
        info = sqlInfo.get();

        CustomTT customTT = new CustomTT(this,R.layout.thongtin_view,info);
        lvThongTin.setAdapter(customTT);
    }


}