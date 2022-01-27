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
import com.example.cvapp2.thongtin.Info;

import java.util.Collections;

public class CustomTT extends ArrayAdapter {
    private Context context;
    private int resource;
    private Info info;

    public CustomTT(@NonNull Context context, int resource, @NonNull Info objects) {
        super(context, resource, Collections.singletonList(objects));
        this.context = context;
        this.resource = resource;
        this.info = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.thongtin_view,parent,false);

        TextView tvName = convertView.findViewById(R.id.tvFullName);
        TextView tvWork = convertView.findViewById(R.id.tvWork_want);
        TextView tvEmail = convertView.findViewById(R.id.tvEmail);
        TextView tvPhone = convertView.findViewById(R.id.tvPhone);
        TextView tvAddress = convertView.findViewById(R.id.tvAddress);
        TextView tvBirth = convertView.findViewById(R.id.tvBirthDay);

        tvAddress.setText(info.getmAddress());
        tvBirth.setText(info.getmBirthday());
        tvEmail.setText(info.getmEmail());
        tvName.setText(info.getmName());
        tvPhone.setText(info.getmPhone());
        tvWork.setText(info.getmWork());

        return convertView;
    }
}
