package com.example.cvapp2.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cvapp2.R;
import com.example.cvapp2.duan.Project;
import com.example.cvapp2.experiencesql.Experience;

import java.util.ArrayList;

public class CustomDA extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Project> projectArrayList;
    public CustomDA(@NonNull Context context, int resource, @NonNull ArrayList<Project> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.projectArrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView  = LayoutInflater.from(context).inflate(R.layout.kinhnghiem_view,parent,false);

        TextView tvWork = convertView.findViewById(R.id.tvWork);
        TextView tvCompany = convertView.findViewById(R.id.tvCompany);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        TextView tvDescribe = convertView.findViewById(R.id.tvDescribe);

        Project project = projectArrayList.get(position);
        tvCompany.setText(project.getCompany());
        tvDate.setText(project.getDate());
        tvDescribe.setText(project.getDescribe());
        tvWork.setText(project.getPositionWork());

        return convertView;
    }
}
