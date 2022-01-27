package com.example.cvapp2.experiencesql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvapp2.MainActivity;
import com.example.cvapp2.R;

import java.util.ArrayList;

public class KinhNghiem extends AppCompatActivity {
    Button btnAdd;
    Button btnSave;
    Button btnCancel;
    ListView listView;
    ArrayList<com.example.cvapp2.experiencesql.Experience> experienceArrayList;
    public static com.example.cvapp2.experiencesql.CustomlvMainEx customlvMainEx;

    public static String Company = "company";
    public static String Position = "position";
    public static String Date = "date";
    public static String Describe = "describe";
    public static String Id = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinh_nghiem);
        initWidget();

        SQLExp SQLExp = new SQLExp(this);
        experienceArrayList = SQLExp.get();
        customlvMainEx = new com.example.cvapp2.experiencesql.CustomlvMainEx(com.example.cvapp2.experiencesql.KinhNghiem.this, R.layout.custom_lv_main, experienceArrayList);
        listView.setAdapter(customlvMainEx);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.cvapp2.experiencesql.KinhNghiem.this, com.example.cvapp2.experiencesql.AddExperience.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                com.example.cvapp2.experiencesql.Experience experience = experienceArrayList.get(position);
                String company = experience.getCompany();
                String positionWork = experience.getPositionWork();
                String date = experience.getDate();
                String describe = experience.getDescribe();
                int idEx = experience.getId();

                Intent intent = new Intent(com.example.cvapp2.experiencesql.KinhNghiem.this, UpdateExperience.class);
                intent.putExtra(Id, idEx);
                intent.putExtra(Company, company);
                intent.putExtra(Position, positionWork);
                intent.putExtra(Date, date);
                intent.putExtra(Describe, describe);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                com.example.cvapp2.experiencesql.Experience experience = experienceArrayList.get(position);
                int result = SQLExp.deleteExperience(experience.getId());
                if(result > 0){
                    experienceArrayList.clear();
                    experienceArrayList.addAll(SQLExp.get());
                    customlvMainEx.notifyDataSetChanged();
                    Toast.makeText(com.example.cvapp2.experiencesql.KinhNghiem.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(com.example.cvapp2.experiencesql.KinhNghiem.this, "Delete Fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        if (experienceArrayList != null) {
            experienceArrayList.clear();
            experienceArrayList.addAll(SQLExp.get());
            customlvMainEx.notifyDataSetChanged();
            listView.setSelection(customlvMainEx.getCount() - 1);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KinhNghiem.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLExp.deleteAll();
                Intent intent = new Intent(KinhNghiem.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public void initWidget() {
        btnAdd = findViewById(R.id.btn_add);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
        listView = findViewById(R.id.lv_main);
    }
}