package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app01sqlite.transacciones.transaccionesClass;

public class ActivityConsulta extends AppCompatActivity {

    SQLiteConexion conexion;
    EditText id, nombre, apellido, edad, correo, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        //Conexion a la BDD
        conexion = new SQLiteConexion(this, transaccionesClass.NameDataBase, null, 1);

        //Botones

        Button consulta = (Button)findViewById(R.id.btn_buscar);
        Button eliminar = (Button)findViewById(R.id.btn_eliminar);
        Button actualizar = (Button)findViewById(R.id.btn_actualizar);

        id = (EditText)findViewById(R.id.txt_id);
        nombre = (EditText)findViewById(R.id.txt_nombre);
        apellido = (EditText)findViewById(R.id.txt_apellido);
        edad = (EditText)findViewById(R.id.txt_edad);
        correo = (EditText)findViewById(R.id.txt_correo);
        direccion = (EditText)findViewById(R.id.txt_direccion);


        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buscar();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar();
            }
        });


        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });

    }

    private void eliminar() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()};

        String wherecondic = transaccionesClass.id + "=?";

        db.delete(transaccionesClass.tabla_personas,wherecondic, params);
        Toast.makeText(getApplicationContext(), "Dato Eliminado", Toast.LENGTH_LONG).show();
        ClearScreen();
    }

    private void actualizar() {

        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()};


        ContentValues valores = new ContentValues();
        valores.put(transaccionesClass.nombres, nombre.getText().toString());
        valores.put(transaccionesClass.apellidos, apellido.getText().toString());
        valores.put(transaccionesClass.edad, edad.getText().toString());
        valores.put(transaccionesClass.correo, correo.getText().toString());
        valores.put(transaccionesClass.direccion, direccion.getText().toString());

        db.update(transaccionesClass.tabla_personas, valores, transaccionesClass.id +"=?", params);
        Toast.makeText(getApplicationContext(), "Dato Actualizado", Toast.LENGTH_LONG).show();
        ClearScreen();
    }

    private void Buscar() {

        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()}; //parametro de la busqueda
        String [] campos = {transaccionesClass.nombres,
                            transaccionesClass.apellidos,
                            transaccionesClass.edad,
                            transaccionesClass.correo,
                            transaccionesClass.direccion};

        String wherecondic = transaccionesClass.id + "=?";

        try {
            Cursor cdata = db.query(transaccionesClass.tabla_personas, campos, wherecondic, params, null, null, null);
            cdata.moveToFirst();

            nombre.setText(cdata.getString(0));
            apellido.setText(cdata.getString(1));
            edad.setText(cdata.getString(2));
            correo.setText(cdata.getString(3));
            direccion.setText(cdata.getString(4));

            Toast.makeText(getApplicationContext(), "Consultado con exito",Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            ClearScreen();
                Toast.makeText(getApplicationContext(), "Elemento no encontrado",Toast.LENGTH_LONG).show();

        }

    }

    private void ClearScreen() {
        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}