package com.example.cvapp2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

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

public class CV1 extends AppCompatActivity implements View.OnClickListener {
    private AppCompatActivity activity = com.example.cvapp2.CV1.this;
    private ConstraintLayout parentView;
    private Button buttonScreenshotActivity;
    private Button buttonScreenshotView;
    private Button buttonSaveScreenshot;
    private Button buttonReset;
    private ImageView imageViewShowScreenshot;
    private Bitmap bitmap, scalebmp;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cv_file);
        // initializing the views
        initViews();
        // initializing the listeners
        initListeners();
        initWidget();

        setLvExp();
        setLvGoals();
        setLvHobby();
        setLvKnowledge();
        setLvProj();
        setLvSkill();
        setLvThongTin();

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

    }

    /**
     * method to initialize the views
     */
    private void initViews() {
        parentView = findViewById(R.id.layout);
        buttonScreenshotActivity = findViewById(R.id.buttonScreenshotActivity);
        //buttonScreenshotView = findViewById(R.id.buttonScreenshotView);
        // buttonSaveScreenshot = findViewById(R.id.buttonSaveScreenshot);
        //buttonReset = findViewById(R.id.buttonReset);
        //imageViewShowScreenshot = findViewById(R.id.imageViewShowScreenshot);
    }

    public void initWidget() {
        lvExp = findViewById(R.id.lvKinhnghiem);
        lvGoals = findViewById(R.id.lvMuctieu);
        lvHobby = findViewById(R.id.lvSothihc);
        lvKnowledge = findViewById(R.id.lvHocvan);
        lvProj = findViewById(R.id.lvDuan);
        lvSkill = findViewById(R.id.lvKinang);
        lvThongTin = findViewById(R.id.lvThongTin);
    }

    /**
     * method to initialize the listeners
     */
    private void initListeners() {
        buttonScreenshotActivity.setOnClickListener(this);
       // buttonScreenshotView.setOnClickListener(this);
        //buttonSaveScreenshot.setOnClickListener(this);
        //buttonReset.setOnClickListener(this);
    }

    public void setLvHobby() {
        SQLHobby sqlHobby = new SQLHobby(this);
        hobby = sqlHobby.get();

        CustomST customST = new CustomST(this, R.layout.sothich_view, hobby);
        lvHobby.setAdapter(customST);
    }

    public void setLvGoals() {
        SQLMucTieu sqlMucTieu = new SQLMucTieu(this);
        goals = sqlMucTieu.get();

        CustomMT customMT = new CustomMT(this, R.layout.muctieu_view, goals);
        lvGoals.setAdapter(customMT);
    }

    public void setLvKnowledge() {
        SQLHocVan sqlHocVan = new SQLHocVan(this);
        knowledge = sqlHocVan.get();

        CustomHV customHV = new CustomHV(this, R.layout.hovan_view, knowledge);
        lvKnowledge.setAdapter(customHV);
    }

    public void setLvExp() {
        SQLExp sqlExp = new SQLExp(this);
        experiences = sqlExp.get();

        CustomKHN customKHN = new CustomKHN(this, R.layout.kinhnghiem_view, experiences);
        lvExp.setAdapter(customKHN);
    }

    public void setLvProj() {
        SQLDuAn sqlDuAn = new SQLDuAn(this);
        projects = sqlDuAn.get();

        CustomDA customDA = new CustomDA(this, R.layout.duan_view, projects);
        lvProj.setAdapter(customDA);
    }

    public void setLvSkill() {
        SQLSkill sqlSkill = new SQLSkill(this);
        skills = sqlSkill.get();

        CustomKN customKN = new CustomKN(this, R.layout.kinang_view, skills);
        lvSkill.setAdapter(customKN);
    }

    public void setLvThongTin() {
        SQLInfo sqlInfo = new SQLInfo(this);
        info = sqlInfo.get();

        CustomTT customTT = new CustomTT(this, R.layout.thongtin_view, info);
        lvThongTin.setAdapter(customTT);
    }

    /**
     * method for click listener
     *
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonScreenshotActivity:
                bitmap = ScreenshotUtil.getInstance().takeScreenshotForView(parentView); // Take ScreenshotUtil for activity
                scalebmp = Bitmap.createBitmap(bitmap, 0, 0, 1000, 1900, null, false);
                PdfDocument pdfDocument = new PdfDocument();
                Paint paint = new Paint();
                PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(1100, 2000, 1).create();
                PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                Canvas canvas = page.getCanvas();

                canvas.drawBitmap(scalebmp, 50, 20, paint);
                pdfDocument.finishPage(page);

                File file = new File(Environment.getExternalStorageDirectory(), "/PDFFile.pdf");

                try {
                    pdfDocument.writeTo(new FileOutputStream(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;


//Create a directory for your PDF
        }
    }

}