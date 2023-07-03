package com.example.chislaundry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    Button btndaftar;
    EditText name, handphone, userId, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btndaftar = findViewById(R.id.btnDaftar3);

        name = findViewById(R.id.name);
        handphone = findViewById(R.id.handphone);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);

        //memasukkan aksi
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating user entity
                UserEntity userEntity = new UserEntity();
                userEntity.setName(name.getText().toString());
                userEntity.setHandphone(handphone.getText().toString());
                userEntity.setUserId(userId.getText().toString());
                userEntity.setPassword(password.getText().toString());
                if (validateInput(userEntity)){
                    //do insert operation
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // register user
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"Akun Berhasil Terdaftar!", Toast.LENGTH_SHORT).show();
                                }
                            });
                            startActivities(new Intent[]{new Intent(getApplicationContext(),signupsukses.class)});
                        }
                    }).start();
                }else{
                    Toast.makeText(getApplicationContext(),"Isi semua kolom!", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
    private Boolean validateInput(UserEntity userEntity){
        if (userEntity.getName().isEmpty()||
            userEntity.getPassword().isEmpty()||
            userEntity.getName().isEmpty()){
            return false;
        }
        return true;
    }
}