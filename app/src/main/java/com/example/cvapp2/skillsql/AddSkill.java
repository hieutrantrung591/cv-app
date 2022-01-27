package com.example.cvapp2.skillsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvapp2.R;

public class AddSkill extends AppCompatActivity {
    Button btnSave;
    SeekBar seekBar;
    EditText nameOfSkill;
    TextView progress1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_skill);
        initWidget();
        SQLSkill SQLSkill = new SQLSkill(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress1.setText(progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.cvapp2.skillsql.Skill skill = createSkill();
                SQLSkill.addSkill(skill);
                Toast.makeText(com.example.cvapp2.skillsql.AddSkill.this    , "Add Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(com.example.cvapp2.skillsql.AddSkill.this, com.example.cvapp2.skillsql.KiNang.class);
                startActivity(intent);
            }
        });
    }

    public void initWidget(){
        btnSave = findViewById(R.id.btn_save_add);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(10);
        seekBar.setProgress(5);
        nameOfSkill = findViewById(R.id.ed_add_skill);
        progress1 = findViewById(R.id.number);
    }

    public com.example.cvapp2.skillsql.Skill createSkill(){
        com.example.cvapp2.skillsql.Skill skill = new com.example.cvapp2.skillsql.Skill(nameOfSkill.getText().toString(),seekBar.getMax(),seekBar.getProgress());

        return skill;
    }
}