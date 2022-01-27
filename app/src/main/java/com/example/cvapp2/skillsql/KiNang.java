package com.example.cvapp2.skillsql;

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

public class KiNang extends AppCompatActivity {
    Button btnAdd;
    Button btnSave;
    Button btnCancel;
    ListView listView;
    ArrayList<Skill> skillArrayList;
    CustomLvSkill customLvSkill;

    public static String name = "name";
    public static String max = "max";
    public static String progress = "progress";
    public static String idS = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinang);

        initWidget();

        SQLSkill SQLSkill = new SQLSkill(this);
        skillArrayList = SQLSkill.get();
        CustomLvSkill customLvSkill = new CustomLvSkill(com.example.cvapp2.skillsql.KiNang.this,R.layout.custom_lv_kinang,skillArrayList);
        listView.setAdapter(customLvSkill);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(com.example.cvapp2.skillsql.KiNang.this,AddSkill.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(com.example.cvapp2.skillsql.KiNang.this, com.example.cvapp2.skillsql.UpdateSkill.class);
                Skill skill = skillArrayList.get(position);
                String nameSkill = skill.getName();
                int maxSkill = skill.getMaxSeekbar();
                int progressSkill = skill.getProgressSeekbar();
                int idSkill = skill.getId();
                intent.putExtra(idS,idSkill);
                intent.putExtra(name,nameSkill);
                intent.putExtra(max,maxSkill);
                intent.putExtra(progress,progressSkill);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Skill skill = skillArrayList.get(position);
                int result =  SQLSkill.deleteSkill(skill.getId());
                skillArrayList.clear();
                skillArrayList.addAll(SQLSkill.get());
                customLvSkill.notifyDataSetChanged();
                if(result > 0 ){
                    Toast.makeText(com.example.cvapp2.skillsql.KiNang.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        if(skillArrayList != null){
            skillArrayList.clear();
            skillArrayList.addAll(SQLSkill.get());
            customLvSkill.notifyDataSetChanged();
            listView.setSelection(customLvSkill.getCount() - 1);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KiNang.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLSkill.deleteAll();

                Intent intent = new Intent(KiNang.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void initWidget(){
        btnAdd = findViewById(R.id.btn_add);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
        listView = findViewById(R.id.lv_main);
    }
}