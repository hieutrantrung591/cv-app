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
import com.example.cvapp2.hocvan.Knowledge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomHV extends ArrayAdapter {
    private Context context;
    private int resource;
    private Knowledge knowledge;

    public CustomHV(@NonNull Context context, int resource, @NonNull Knowledge objects) {
        super(context, resource, Collections.singletonList(objects));
        this.context = context;
        this.resource = resource;
        this.knowledge = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.hovan_view,parent,false);

        TextView tvSchool = convertView.findViewById(R.id.tvSchool);
        TextView tvMajor = convertView.findViewById(R.id.tvMajor);
        TextView tvRank = convertView.findViewById(R.id.tvRank);

        Knowledge knowledge1 = knowledge;
        tvSchool.setText(knowledge1.getmNameSchool());
        tvMajor.setText(knowledge1.getmMajor());
        tvRank.setText(knowledge1.getmRank());

        return convertView;
    }
}
