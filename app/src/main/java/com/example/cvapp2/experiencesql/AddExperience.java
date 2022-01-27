package com.example.cvapp2.experiencesql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvapp2.R;

public class AddExperience extends AppCompatActivity {
    Button btnSaveAdd;
    EditText edCompany;
    EditText edPosition;
    EditText edDate;
    EditText edDescribe;
    Button btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_experience);

        initWidget();
        SQLExp sqlExp = new SQLExp(this);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.cvapp2.experiencesql.AddExperience.this, KinhNghiem.class);
                startActivity(intent);
            }
        });

        btnSaveAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.cvapp2.experiencesql.Experience experience = createExperience();
                if (experience != null) {
                    sqlExp.addExperience(experience);
                }

                Intent intent = new Intent(com.example.cvapp2.experiencesql.AddExperience.this, KinhNghiem.class);
                startActivity(intent);
            }
        });
    }

    public void initWidget() {
        btnSaveAdd = findViewById(R.id.btn_save_add);
        edCompany = findViewById(R.id.ed_company);
        edDate = findViewById(R.id.ed_date);
        edPosition = findViewById(R.id.ed_position);
        edDescribe = findViewById(R.id.ed_describe);
        btnHuy = findViewById(R.id.btn_huy);
    }

    public com.example.cvapp2.experiencesql.Experience createExperience() {

        String company = edCompany.getText().toString();
        String position = edPosition.getText().toString();
        String date = edDate.getText().toString();
        String describe = edDescribe.getText().toString();

        com.example.cvapp2.experiencesql.Experience experience = new com.example.cvapp2.experiencesql.Experience(company, position, date, describe);


        return experience;
    }
}