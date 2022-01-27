package com.example.cvapp2.skillsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvapp2.R;

public class UpdateSkill extends AppCompatActivity {
    Button btnSave;
    SeekBar seekBar;
    EditText nameOfSkill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_skill);
        initWidget();
        SQLSkill SQLSkill = new SQLSkill(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra(KiNang.name);
        int max = intent.getIntExtra(KiNang.max,100);
        int progress = intent.getIntExtra(KiNang.progress,50);
        int idSkill = intent.getIntExtra(KiNang.idS,0);

        nameOfSkill.setText(name);
        seekBar.setMax(max);
        seekBar.setProgress(progress);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Skill skill = new Skill(idSkill,nameOfSkill.getText().toString(),seekBar.getMax(),seekBar.getProgress());
                if(skill.getName() != null){
                    int result = SQLSkill.updateSkill(skill);
                    if(result > 0){
                        Toast.makeText(com.example.cvapp2.skillsql.UpdateSkill.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                    }
                }

                Intent intent1 = new Intent(com.example.cvapp2.skillsql.UpdateSkill.this, KiNang.class);
                startActivity(intent1);
            }
        });
    }

    public void initWidget(){
        btnSave = findViewById(R.id.btn_save_add);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setProgress(50);
        nameOfSkill = findViewById(R.id.ed_add_skill);
    }

}