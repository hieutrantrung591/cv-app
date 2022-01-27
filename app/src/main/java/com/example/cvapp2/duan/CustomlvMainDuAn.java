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

public class CustomlvMainDuAn extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Project> projects;

    public CustomlvMainDuAn(@NonNull Context context, int resource, @NonNull ArrayList<Project> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.projects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_lv_main_duan, parent, false);
        TextView nameCompany = convertView.findViewById(R.id.tv_name_company);

        Project project = projects.get(position);
        nameCompany.setText(project.getCompany());

        return convertView;
    }
}
