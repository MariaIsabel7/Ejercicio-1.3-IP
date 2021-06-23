package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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