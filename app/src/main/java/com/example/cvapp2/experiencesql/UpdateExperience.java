package com.example.cvapp2.experiencesql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvapp2.R;

public class UpdateExperience extends AppCompatActivity {
    Button btnSaveUpdate;
    EditText edCompany;
    EditText edPosition;
    EditText edDate;
    EditText edDescribe;
    Button btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_experience);
        initWidget();
        SQLExp SQLExp = new SQLExp(this);

        Intent intent = getIntent();
        String company = intent.getStringExtra(com.example.cvapp2.experiencesql.KinhNghiem.Company);
        String position = intent.getStringExtra(com.example.cvapp2.experiencesql.KinhNghiem.Position);
        String date = intent.getStringExtra(com.example.cvapp2.experiencesql.KinhNghiem.Date);
        String describe = intent.getStringExtra(com.example.cvapp2.experiencesql.KinhNghiem.Describe);
        int id = intent.getIntExtra(com.example.cvapp2.experiencesql.KinhNghiem.Id,0);

        edCompany.setText(company);
        edPosition.setText(position);
        edDate.setText(date);
        edDescribe.setText(describe);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.cvapp2.experiencesql.UpdateExperience.this, com.example.cvapp2.experiencesql.KinhNghiem.class);
                startActivity(intent);
            }
        });


        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.cvapp2.experiencesql.Experience experience = new com.example.cvapp2.experiencesql.Experience(edCompany.getText().toString(),edPosition.getText().toString(),
                        edDate.getText().toString(),edDescribe.getText().toString(),id);
                int result = SQLExp.updateExperience(experience);
                if(result>0){
                    //com.example.cvapp2.skillsql.KinhNghiem.customlvMainEx.notifyDataSetChanged();
                    Toast.makeText(com.example.cvapp2.experiencesql.UpdateExperience.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(com.example.cvapp2.experiencesql.UpdateExperience.this, "Update Fail", Toast.LENGTH_SHORT).show();
                }

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                Intent intent1 = new Intent(com.example.cvapp2.experiencesql.UpdateExperience.this, com.example.cvapp2.experiencesql.KinhNghiem.class);
                startActivity(intent1);
            }
        });
    }

    public void initWidget(){
        btnSaveUpdate = findViewById(R.id.btn_save_add);
        edCompany = findViewById(R.id.ed_company);
        edDate = findViewById(R.id.ed_date);
        edPosition = findViewById(R.id.ed_position);
        edDescribe = findViewById(R.id.ed_describe);
        btnHuy = findViewById(R.id.btn_huy2);
    }
}