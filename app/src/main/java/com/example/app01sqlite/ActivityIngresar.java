package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app01sqlite.transacciones.transaccionesClass;

public class ActivityIngresar extends AppCompatActivity {

    EditText nombre, apellido, edad, correo, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        Button btn = (Button)findViewById(R.id.button);
        nombre = (EditText)findViewById(R.id.txt_nombre);
        apellido = (EditText)findViewById(R.id.txt_apellido);
        edad = (EditText)findViewById(R.id.txt_edad);
        correo = (EditText)findViewById(R.id.txt_correo);
        direccion = (EditText)findViewById(R.id.txt_direccion);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aggperson();
            }
        });


    }

    private void aggperson() {
        SQLiteConexion conexion = new SQLiteConexion(this, transaccionesClass.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(transaccionesClass.nombres, nombre.getText().toString());
        valores.put(transaccionesClass.apellidos, apellido.getText().toString());
        valores.put(transaccionesClass.edad, edad.getText().toString());
        valores.put(transaccionesClass.correo, correo.getText().toString());
        valores.put(transaccionesClass.direccion, direccion.getText().toString());

        Long resultado = db.insert(transaccionesClass.tabla_personas, transaccionesClass.id, valores);

        //Toast
        Toast.makeText(getApplicationContext(), "REGISTRO INGRESADO: " + resultado.toString(), Toast.LENGTH_LONG).show();


        db.close();

        ClearScreen();
    }

    private void ClearScreen() {
        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}