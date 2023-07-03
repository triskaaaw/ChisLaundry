package com.example.chislaundry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity{

    TextView tName;
    Button btndetail;
    ImageButton btnhome, btnriwayat, btnprofil, btnkeranjang, btncucisetrika, btnsetrika, btnpremiumwash, btndrycleaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tName.setText(name);
        btndetail = findViewById(R.id.btnDetail);
        btnhome = findViewById(R.id.btnHome);
        btnriwayat = findViewById(R.id.btnRiwayat);
        btnprofil = findViewById(R.id.btnProfil);
        btnkeranjang = findViewById(R.id.btnKeranjang);
        btncucisetrika = findViewById(R.id.btnCucisetrika);
        btnsetrika = findViewById(R.id.btnSetrika);
        btnpremiumwash = findViewById(R.id.btnPremiumwash);
        btndrycleaning = findViewById(R.id.btnDrycleaning);

        //memasukkan aksi
        btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),DetaillaundryActivity.class)});
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),home.class)});
            }
        });

        btnriwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),home.class)});
            }
        });

        btnprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),profil.class)});
            }
        });

        btnkeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),home.class)});
            }
        });

        btncucisetrika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),CucisetrikaActivity.class)});
            }
        });

        btnsetrika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),setrika.class)});
            }
        });

        btnpremiumwash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),premiumwash.class)});
            }
        });

        btndrycleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),drycleaning.class)});
            }
        });
    }
}
