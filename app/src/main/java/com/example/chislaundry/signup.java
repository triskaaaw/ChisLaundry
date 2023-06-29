package com.example.chislaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    Button btndaftar;
    EditText etnama, etphone, etemail, etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btndaftar = findViewById(R.id.btnDaftar3);

        etnama = findViewById(R.id.etNama);
        etphone = findViewById(R.id.etPhone);
        etemail = findViewById(R.id.etEmail2);
        etpass = findViewById(R.id.etPass2);

        //memasukkan aksi
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),signupsukses.class)});
            }
        });
    }
}