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
import java.util.List;

public class CustomKHN extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Experience> experienceArrayList;
    public CustomKHN(@NonNull Context context, int resource, @NonNull ArrayList<Experience> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.experienceArrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView  = LayoutInflater.from(context).inflate(R.layout.kinhnghiem_view,parent,false);

        TextView tvWork = convertView.findViewById(R.id.tvWork);
        TextView tvCompany = convertView.findViewById(R.id.tvCompany);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        TextView tvDescribe = convertView.findViewById(R.id.tvDescribe);

        Experience experience = experienceArrayList.get(position);
        tvCompany.setText(experience.getCompany());
        tvDate.setText(experience.getDate());
        tvDescribe.setText(experience.getDescribe());
        tvWork.setText(experience.getPositionWork());

        return convertView;
    }
}
