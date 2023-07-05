package com.example.chislaundry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chislaundry.views.CartActivity;
import com.example.chislaundry.views.MainActivity2;

public class home extends AppCompatActivity{

    TextView tName;
    Button btndetail;
    ImageButton btnhome, btnriwayat, btnprofil, btnkeranjang, buttonpemesanan, buttonjenislayanan, buttonhubungikami, buttonlihatlokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tName.setText(name);
        btnhome = findViewById(R.id.btnHome);
        btnriwayat = findViewById(R.id.btnRiwayat);
        btnprofil = findViewById(R.id.btnProfil);
        btnkeranjang = findViewById(R.id.btnKeranjang);
        buttonpemesanan = findViewById(R.id.buttonPemesanan);
        buttonjenislayanan = findViewById(R.id.buttonJenislayanan);
        buttonhubungikami = findViewById(R.id.buttonHubungikami);
        buttonlihatlokasi = findViewById(R.id.buttonLihatlokasi);

        //memasukkan aksi

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
                startActivities(new Intent[]{new Intent(getApplicationContext(), CartActivity.class)});
            }
        });

        buttonpemesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),MainActivity2.class)});
            }
        });

        buttonjenislayanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(getApplicationContext(),DetaillaundryActivity.class)});
            }
        });

        buttonhubungikami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Halo%20Saya%20mau%20/%20bertanya%20tentang%20pemesanan%20jasa%20laundry%20di%20CHIS%20Laundry.";
                String url = String.format("https://wa.me/+6282247605073?text=%s",text);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        buttonlihatlokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q=-8.795945132892731, 115.17621799491707");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
