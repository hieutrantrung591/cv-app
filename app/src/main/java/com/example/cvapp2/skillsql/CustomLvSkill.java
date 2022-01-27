package com.example.cvapp2.skillsql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cvapp2.R;

import java.util.ArrayList;

public class CustomLvSkill extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Skill> skillArrayList;
    public CustomLvSkill(@NonNull Context context, int resource, @NonNull ArrayList<Skill> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.skillArrayList  = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_lv_kinang,parent,false);

        SeekBar seekBar = convertView.findViewById(R.id.seekBar);
        TextView nameOfSkill = convertView.findViewById(R.id.tv_name_skill);
        TextView progress1 = convertView.findViewById(R.id.tv_progress);

        Skill skill = skillArrayList.get(position);
        nameOfSkill.setText(skill.getName());
        progress1.setText(skill.getProgressSeekbar() + "/" + skill.getMaxSeekbar());
        seekBar.setProgress(skill.getProgressSeekbar());
        seekBar.setMax(skill.getMaxSeekbar());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress1.setText(skill.getProgressSeekbar() + "/" + skill.getMaxSeekbar());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setEnabled(false);

        return convertView;
    }
}
