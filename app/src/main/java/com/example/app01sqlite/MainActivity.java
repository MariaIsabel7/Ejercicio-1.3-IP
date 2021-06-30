package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_lista = (Button)findViewById(R.id.btn_lista);
        btn_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityListview.class);
                startActivity(intent);
            }
        });



       Button btn_mapa = (Button)findViewById(R.id.btn_mapa);
        btn_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityMapa.class);
                startActivity(intent);
            }
        });

        Button btn_combo = (Button)findViewById(R.id.btn_combo);
        btn_combo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityCombo.class);
                startActivity(intent);
            }
        });

        Button btn_foto = (Button)findViewById(R.id.btn_foto);
        btn_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityFoto.class);
                startActivity(intent);
            }
        });

        Button btn_video = (Button)findViewById(R.id.btn_videoMain);
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityVideo.class);
                startActivity(intent);
            }
        });
    }

    public void clicknew(View view) {
        Intent intent = new Intent( this, ActivityIngresar.class);
        startActivity(intent);
    }

    public void clicknew2(View view) {
        Intent intent = new Intent( this, ActivityConsulta.class);
        startActivity(intent);
    }
}