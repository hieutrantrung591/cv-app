package com.example.cvapp2.hocvan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cvapp2.MainActivity;
import com.example.cvapp2.R;

public class Tab1 extends Fragment {

    Button btnHuy;
    Button btnLuu;
    EditText edName;
    EditText edMajor;
    EditText edRank;

    SQLHocVan sqlHocVan;
    public static Knowledge knowledgeFinal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);
        sqlHocVan = new SQLHocVan(getContext());

        btnHuy = view.findViewById(R.id.btn_Huy);
        btnLuu = view.findViewById(R.id.btn_Luu);
        edName = view.findViewById(R.id.edNameSchool);
        edMajor = view.findViewById(R.id.edMajor);
        edRank = view.findViewById(R.id.edRank);

        Intent intent = getActivity().getIntent();
        edName.setText(intent.getStringExtra(MainActivity.SCHOOL));
        edMajor.setText(intent.getStringExtra(MainActivity.MAJOR));
        edRank.setText(intent.getStringExtra(MainActivity.RANK));

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Knowledge knowledge = createKnowledge();
                sqlHocVan.addKnowledge(knowledge);
                Intent intent1 = new Intent(getActivity(), MainActivity.class);
                startActivity(intent1);

            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlHocVan.delete();
                Intent intent2 = new Intent(getActivity(), MainActivity.class);
                startActivity(intent2);
            }
        });
        return view;
    }

    public Knowledge createKnowledge() {
        String school = edName.getText().toString();
        String major = edMajor.getText().toString();
        String rank = edRank.getText().toString();

        Knowledge knowledge = new Knowledge(school, major, rank);

        return knowledge;

    }
}
