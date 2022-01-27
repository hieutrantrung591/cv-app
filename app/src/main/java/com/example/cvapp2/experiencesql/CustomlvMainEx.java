package com.example.cvapp2.experiencesql;

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

public class CustomlvMainEx extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<com.example.cvapp2.experiencesql.Experience> experiences;

    public CustomlvMainEx(@NonNull Context context, int resource, @NonNull ArrayList<com.example.cvapp2.experiencesql.Experience> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.experiences = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_lv_main, parent, false);
        TextView nameCompany = convertView.findViewById(R.id.tv_name_company);

      com.example.cvapp2.experiencesql.Experience experience = experiences.get(position);
        nameCompany.setText(experience.getCompany());

        return convertView;
    }
}
