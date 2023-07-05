package com.example.chislaundry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chislaundry.views.MainActivity2;

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
                startActivities(new Intent[]{new Intent(getApplicationContext(), MainActivity2.class)});
            }
        });
        btnsetrika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(), MainActivity2.class)});
            }
        });
        btndrycleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(), MainActivity2.class)});
            }
        });
        btnpremiumwash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(), MainActivity2.class)});
            }
        });
        btnalamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q=-8.795945132892731, 115.17621799491707");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}