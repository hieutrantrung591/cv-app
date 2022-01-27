package com.example.cvapp2.custom;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cvapp2.R;
import com.example.cvapp2.skillsql.Skill;

import java.util.ArrayList;
import java.util.List;

public class CustomKN extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Skill> skillArrayList;
    public CustomKN(@NonNull Context context, int resource, @NonNull ArrayList<Skill> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.skillArrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.kinang_view,parent,false);

        TextView []progressColor = new TextView[10];
       progressColor[0] = convertView.findViewById(R.id.tv1);
       progressColor[1] = convertView.findViewById(R.id.tv);
       progressColor[2] = convertView.findViewById(R.id.tv2);
       progressColor[3] = convertView.findViewById(R.id.tv3);
       progressColor[4] = convertView.findViewById(R.id.tv4);
       progressColor[5] = convertView.findViewById(R.id.tv5);
       progressColor[6] = convertView.findViewById(R.id.tv6);
       progressColor[7] = convertView.findViewById(R.id.tv7);
       progressColor[8] = convertView.findViewById(R.id.tv8);
       progressColor[9] = convertView.findViewById(R.id.tv9);

       TextView tvName = convertView.findViewById(R.id.tvNameSkill);

       Skill skill = skillArrayList.get(position);
       int progressSeekbar = skill.getProgressSeekbar();
       tvName.setText(skill.getName().toString());

        for (int i = 0; i <progressSeekbar ; i++) {
            progressColor[i].setBackgroundColor(Color.RED);
        }

        for (int i = progressSeekbar; i < 10 ; i++){
            progressColor[i].setBackgroundColor(Color.BLUE);
        }
        return  convertView;
    }
}
