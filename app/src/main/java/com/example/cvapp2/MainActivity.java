package com.example.cvapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cvapp2.duan.DuAn;
import com.example.cvapp2.duan.SQLDuAn;
import com.example.cvapp2.experiencesql.KinhNghiem;
import com.example.cvapp2.experiencesql.SQLExp;
import com.example.cvapp2.hocvan.HocVanP;
import com.example.cvapp2.hocvan.Knowledge;
import com.example.cvapp2.hocvan.SQLHocVan;
import com.example.cvapp2.muctieu.Goals;
import com.example.cvapp2.muctieu.MucTieu;
import com.example.cvapp2.muctieu.SQLMucTieu;
import com.example.cvapp2.skillsql.KiNang;
import com.example.cvapp2.skillsql.SQLSkill;
import com.example.cvapp2.sothich.Hobby;
import com.example.cvapp2.sothich.SQLHobby;
import com.example.cvapp2.sothich.SoThich;
import com.example.cvapp2.thongtin.Info;
import com.example.cvapp2.thongtin.SQLInfo;
import com.example.cvapp2.thongtin.ThongTin;

import java.security.Key;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button testButton1;
    Button testButton2;
    Button testButton3;
    Button testButton4;
    Button testButton5;
    Button testButton6;
    Button testButton7;
    Button testButton8;
    Button testButton9;

    SQLHocVan sqlHocVan;
    SQLInfo sqlInfo;
    SQLMucTieu sqlMucTieu;
    SQLHobby sqlHobby;
    SQLSkill sqlSkill;
    SQLExp sqlExp;
    SQLDuAn sqlDuAn;

    public static String SCHOOL = "school";
    public static String MAJOR = "major";
    public static String RANK = "rank";

    public static String FULL_NAME = "";
    public static String WORK = "work";
    public static String EMAIL = "email";
    public static String PHONE = "phone";
    public static String DATE = "date";
    public static String SEX = "sex";
    public static String ADDRESS = "address";

    public static final String GOALS = "goal";
    public static final String HOBBY = "hobby";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqlHocVan = new SQLHocVan(this);
        sqlInfo = new SQLInfo(this);
        sqlMucTieu = new SQLMucTieu(this);
        sqlHobby = new SQLHobby(this);
        sqlSkill = new SQLSkill(this);
        sqlDuAn = new SQLDuAn(this);
        sqlExp = new SQLExp(this);

        initWidget();

        setDuAn();
        setHocVan();
        setKiNang();
        setKinhNghiem();
        setMucTieu();
        setSoThich();
        setThongTin();

        testButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CV1.class);
                startActivity(intent);
            }
        });

        testButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlHobby.deleteHobby();
                sqlMucTieu.deleteGoals();
                sqlInfo.delete();
                sqlHocVan.delete();
                sqlSkill.deleteAll();
                sqlExp.deleteAll();
                sqlDuAn.deleteAll();
            }
        });
    }

    public void setThongTin() {
        testButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info info = sqlInfo.get();
                Intent intent7 = new Intent(MainActivity.this, ThongTin.class);
                intent7.putExtra(FULL_NAME, info.getmName());
                intent7.putExtra(WORK, info.getmWork());
                intent7.putExtra(EMAIL, info.getmEmail());
                intent7.putExtra(ADDRESS, info.getmAddress());
                intent7.putExtra(PHONE, info.getmPhone());
                intent7.putExtra(DATE, info.getmBirthday());
                intent7.putExtra(SEX, info.getmSex());
                startActivity(intent7);
            }
        });
    }

    public void setMucTieu() {
        testButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Goals goals = sqlMucTieu.get();
                Intent intent1 = new Intent(MainActivity.this, MucTieu.class);
                intent1.putExtra(GOALS, goals.getmGoals());
                startActivity(intent1);
            }
        });
    }

    public void setDuAn() {
        testButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(MainActivity.this, DuAn.class);
                startActivity(intent6);
            }
        });
    }

    public void setKiNang() {
        testButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(MainActivity.this, KiNang.class);
                startActivity(intent5);
            }
        });
    }

    public void setHocVan() {
        testButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                Knowledge knowledge = sqlHocVan.get();
                Intent intent3 = new Intent(MainActivity.this, HocVanP.class);
                intent3.putExtra(SCHOOL, knowledge.getmNameSchool());
                intent3.putExtra(MAJOR, knowledge.getmMajor());
                intent3.putExtra(RANK, knowledge.getmRank());
                startActivity(intent3);
            }
        });
    }

    public void setKinhNghiem() {
        testButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, KinhNghiem.class);
                startActivity(intent4);

            }
        });
    }

    public void setSoThich() {
        testButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Hobby hobby = sqlHobby.get();
                Intent intent2 = new Intent(MainActivity.this, SoThich.class);
                intent2.putExtra(HOBBY, hobby.getmHobby());
                startActivity(intent2);
            }
        });
    }

    public void initWidget() {
        testButton1 = (Button) findViewById(R.id.buttonMucTieu);
        testButton2 = (Button) findViewById(R.id.buttonSoThich);
        testButton3 = (Button) findViewById(R.id.buttonHocVan);
        testButton4 = (Button) findViewById(R.id.buttonKinhNghiem);
        testButton5 = (Button) findViewById(R.id.buttonKyNang);
        testButton6 = (Button) findViewById(R.id.buttonDuAn);
        testButton7 = (Button) findViewById(R.id.buttonThongTin);
        testButton8 = findViewById(R.id.buttonLuu);
        testButton9 = findViewById(R.id.buttonHuy);
    }


}