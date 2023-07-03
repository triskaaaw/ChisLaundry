package com.example.chislaundry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login2 extends AppCompatActivity {

    Button btnmasuk, btndaftar;

    EditText userId, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btnmasuk = findViewById(R.id.btnMasuk2);
        btndaftar = findViewById(R.id.btnDaftar2);

        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);

        //menambahkan aksi
        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userIdText = userId.getText().toString();
                String passwordText = password.getText().toString();
                if(userIdText.isEmpty()||passwordText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isi Semua Kolom!", Toast.LENGTH_SHORT).show();
                }else{
                    //query
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.btnmasuk(userIdText, passwordText);
                            if(userEntity==null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Kata Sandi Tidak Valid!",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                String name = userEntity.name;
                                startActivity(new Intent(Login2.this, home.class)
                                        .putExtra("name", name));
                            }
                        }
                    }).start();
                }
                //startActivities(new Intent[]{new Intent(getApplicationContext(),home.class)});
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