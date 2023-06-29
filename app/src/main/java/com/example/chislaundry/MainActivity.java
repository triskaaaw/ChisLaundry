package com.example.chislaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import android.window.SplashScreen;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        time();
        };

   private void time(){
       new Timer().schedule(new TimerTask() {
           @Override
           public void run() {
               Intent intent = new Intent(MainActivity.this, login.class);
               startActivity(intent);
           }
       },2000);
    }
}