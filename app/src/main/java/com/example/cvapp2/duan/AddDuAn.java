package com.example.cvapp2.duan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvapp2.R;

public class AddDuAn extends AppCompatActivity {
    Button btnSaveAddPrj;
    EditText edCompany;
    EditText edPosition;
    EditText edDate;
    EditText edDescribe;
    Button btnHuyPrj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_duan);

        initWidget();
        SQLDuAn SQLDuAn = new SQLDuAn(this);

        btnHuyPrj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.cvapp2.duan.AddDuAn.this, com.example.cvapp2.duan.DuAn.class);
                startActivity(intent);
            }
        });

        btnSaveAddPrj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.cvapp2.duan.Project project = createExperience();
                if (project != null) {
                    SQLDuAn.addExperience(project);
                }

                Intent intent = new Intent(com.example.cvapp2.duan.AddDuAn.this, com.example.cvapp2.duan.DuAn.class);
                startActivity(intent);
            }
        });
    }

    public void initWidget() {
        btnSaveAddPrj = findViewById(R.id.btn_save_add_prj);
        edCompany = findViewById(R.id.ed_company_prj);
        edDate = findViewById(R.id.ed_date_prj);
        edPosition = findViewById(R.id.ed_position_prj);
        edDescribe = findViewById(R.id.ed_describe_prj);
        btnHuyPrj = findViewById(R.id.btn_huy_prj);
    }

    public com.example.cvapp2.duan.Project createExperience() {

        String company = edCompany.getText().toString();
        String position = edPosition.getText().toString();
        String date = edDate.getText().toString();
        String describe = edDescribe.getText().toString();

        com.example.cvapp2.duan.Project project = new com.example.cvapp2.duan.Project(company, position, date, describe);


        return project;
    }
}