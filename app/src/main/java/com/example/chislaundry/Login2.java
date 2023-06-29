package com.example.chislaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login2 extends AppCompatActivity {

    Button btnmasuk, btndaftar;

    EditText etemail, etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btnmasuk = findViewById(R.id.btnMasuk2);
        btndaftar = findViewById(R.id.btnDaftar2);

        etemail = findViewById(R.id.etEmail);
        etpass = findViewById(R.id.etPass);

        //menambahkan aksi
        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),home.class)});
            }
        });

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),signup.class)});
            }
        });
    }
}