package com.example.chislaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class signupsukses extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupsukses);
        time();
    }

    private void time(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(signupsukses.this,Login2.class);
                startActivity(intent);
            }
        },2000);
    }

}
