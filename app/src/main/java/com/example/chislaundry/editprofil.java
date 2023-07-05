package com.example.chislaundry;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class editprofil extends AppCompatActivity {
    TextView tampilName, tampilHandphone, tampilEmail, tampilPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofil);

        tampilName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tampilName.setText(name);

        tampilHandphone = findViewById(R.id.handphone);
        String handphone = getIntent().getStringExtra("handphone");
        tampilHandphone.setText(handphone);

        tampilEmail = findViewById(R.id.userId);
        String email = getIntent().getStringExtra("email");
        tampilEmail.setText(email);

        tampilPassword = findViewById(R.id.password);
        String password = getIntent().getStringExtra("password");
        tampilPassword.setText(password);
    }
}
