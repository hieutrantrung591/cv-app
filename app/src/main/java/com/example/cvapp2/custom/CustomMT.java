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
import com.example.cvapp2.muctieu.Goals;

import java.util.Collections;
import java.util.List;

public class CustomMT extends ArrayAdapter {
    private Context context;
    private int resource;
    private Goals goals;
    public CustomMT(@NonNull Context context, int resource, @NonNull Goals objects) {
        super(context, resource, Collections.singletonList(objects));
        this.context = context;
        this.resource = resource;
        this.goals = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.muctieu_view,parent,false);

        TextView tvMuctieu = convertView.findViewById(R.id.tvMucieu);

        tvMuctieu.setText(goals.getmGoals());

        return convertView;

    }
}
