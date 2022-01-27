package com.example.cvapp2.thongtin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cvapp2.MainActivity;
import com.example.cvapp2.R;

public class ThongTin extends AppCompatActivity {
    EditText hoten, congViec, email, diachi, dienthoai, ngaysinh, gioitinh;
    Button btnSave, btnHuy;
    SQLInfo sqlInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
        sqlInfo = new SQLInfo(this);

        initWidget();

        Intent intent = getIntent();
        hoten.setText(intent.getStringExtra(MainActivity.FULL_NAME));
        congViec.setText(intent.getStringExtra(MainActivity.WORK));
        email.setText(intent.getStringExtra(MainActivity.EMAIL));
        diachi.setText(intent.getStringExtra(MainActivity.ADDRESS));
        dienthoai.setText(intent.getStringExtra(MainActivity.PHONE));
        ngaysinh.setText(intent.getStringExtra(MainActivity.DATE));
        gioitinh.setText(intent.getStringExtra(MainActivity.SEX));


        setInfo();
        deleteInfo();
    }

    public void initWidget() {
        hoten = findViewById(R.id.edHoTen);
        congViec = findViewById(R.id.edCongViec);
        email = findViewById(R.id.edEmail);
        diachi = findViewById(R.id.edDiaChi);
        dienthoai = findViewById(R.id.edSDT);
        ngaysinh = findViewById(R.id.edSinhNhat);
        gioitinh = findViewById(R.id.edGioiTinh);
        btnSave = findViewById(R.id.btnSaveInfo);
        btnHuy = findViewById(R.id.btnHuy);
    }

    public void setInfo() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info info = createInfo();
                sqlInfo.addInfo(info);

                Intent intent = new Intent(ThongTin.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void deleteInfo() {
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlInfo.delete();

                Intent intent = new Intent(ThongTin.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public Info createInfo() {
        Info info = new Info(hoten.getText().toString(), congViec.getText().toString(), email.getText().toString(),
                diachi.getText().toString(), dienthoai.getText().toString(), ngaysinh.getText().toString(),
                gioitinh.getText().toString());

        return info;
    }

}