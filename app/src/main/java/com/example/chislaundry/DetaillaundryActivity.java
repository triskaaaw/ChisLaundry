package com.example.chislaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetaillaundryActivity extends AppCompatActivity {

    ImageView btncucisetrika, btnsetrika, btndrycleaning, btnpremiumwash;
    Button btnalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailaundry);

        btncucisetrika = findViewById(R.id.btnCucisetrika2);
        btnsetrika = findViewById(R.id.btnSetrika2);
        btndrycleaning = findViewById(R.id.btnDrycleaning2);
        btnpremiumwash = findViewById(R.id.btnPremiumwash2);
        btnalamat = findViewById(R.id.btnAlamat);

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
        btndrycleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),drycleaning.class)});
            }
        });
        btnpremiumwash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),premiumwash.class)});
            }
        });
        btnalamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),home.class)});
            }
        });
    }
}