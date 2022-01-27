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
import com.example.cvapp2.sothich.Hobby;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomST extends ArrayAdapter {
    private Context context;
    private int resource;
    private Hobby hobby;

    public CustomST(@NonNull Context context, int resource, @NonNull Hobby objects) {
        super(context, resource, Collections.singletonList(objects));
        this.context = context;
        this.resource = resource;
        this.hobby = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.sothich_view, parent, false);

        TextView tvHobby = convertView.findViewById(R.id.tvSothich);
        tvHobby.setText(hobby.getmHobby());


        return convertView;
    }
}
