package com.example.cvapp2.duan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cvapp2.R;

import java.util.ArrayList;

public class CustomLvDuAn extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<com.example.cvapp2.duan.Project> projects;

    public CustomLvDuAn(@NonNull Context context, int resource, @NonNull ArrayList<com.example.cvapp2.duan.Project> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.projects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_lv_duan, parent, false);

        TextView nameOfCompany = convertView.findViewById(R.id.tv_company);
        TextView positionWork = convertView.findViewById(R.id.tv_position);
        TextView date = convertView.findViewById(R.id.tv_date);
        TextView describe = convertView.findViewById(R.id.tv_describe);

        com.example.cvapp2.duan.Project project = projects.get(position);
        nameOfCompany.setText(project.getCompany());
        positionWork.setText(project.getPositionWork());
        date.setText(project.getDate());
        describe.setText(project.getDescribe());

        return convertView;
    }
}
