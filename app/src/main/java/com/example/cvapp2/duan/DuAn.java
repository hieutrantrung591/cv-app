package com.example.cvapp2.duan;

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

public class DuAn extends AppCompatActivity {
    Button btnAdd;
    Button btnSave;
    Button btnCancel;
    ListView listView;
    ArrayList<Project> projectArrayList;
    public static com.example.cvapp2.duan.CustomlvMainDuAn customlvMainDuAn;

    public static String Company = "company";
    public static String Position = "position";
    public static String Date = "date";
    public static String Describe = "describe";
    public static String Id = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duan);
        initWidget();

        SQLDuAn SQLDuAn = new SQLDuAn(this);
        projectArrayList = SQLDuAn.get();
        customlvMainDuAn = new com.example.cvapp2.duan.CustomlvMainDuAn(com.example.cvapp2.duan.DuAn.this, R.layout.custom_lv_main_duan, projectArrayList);
        listView.setAdapter(customlvMainDuAn);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.cvapp2.duan.DuAn.this, AddDuAn.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Project project = projectArrayList.get(position);
                String company = project.getCompany();
                String positionWork = project.getPositionWork();
                String date = project.getDate();
                String describe = project.getDescribe();
                int idEx = project.getId();

                Intent intent = new Intent(com.example.cvapp2.duan.DuAn.this, UpdateDuAn.class);
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
                Project project = projectArrayList.get(position);
                int result = SQLDuAn.deleteExperience(project.getId());
                if(result > 0){
                    projectArrayList.clear();
                    projectArrayList.addAll(SQLDuAn.get());
                    customlvMainDuAn.notifyDataSetChanged();
                    Toast.makeText(com.example.cvapp2.duan.DuAn.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(com.example.cvapp2.duan.DuAn.this, "Delete Fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        if (projectArrayList != null) {
            projectArrayList.clear();
            projectArrayList.addAll(SQLDuAn.get());
            customlvMainDuAn.notifyDataSetChanged();
            listView.setSelection(customlvMainDuAn.getCount() - 1);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuAn.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLDuAn.deleteAll();
                Intent intent = new Intent(DuAn.this,MainActivity.class);
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