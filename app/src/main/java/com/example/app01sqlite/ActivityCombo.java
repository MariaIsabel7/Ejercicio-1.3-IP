package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.app01sqlite.tables.personaClass;
import com.example.app01sqlite.transacciones.transaccionesClass;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {


    //variables globales//

    SQLiteConexion conexion;
    Spinner comboPersonas;
    EditText nombre, apellido, correo;

    ArrayList<String> listaPersonas;
    ArrayList<personaClass> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLiteConexion(this, transaccionesClass.NameDataBase, null, 1);
        comboPersonas = (Spinner) findViewById(R.id.combo_persona);
        nombre = (EditText) findViewById(R.id.txt_nom);
        apellido = (EditText) findViewById(R.id.txt_app);
        correo = (EditText) findViewById(R.id.txt_email);

        ObtenerListaPersonas();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaPersonas);
        comboPersonas.setAdapter(adp);


        comboPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nombre.setText(lista.get(position).getNombre());
                apellido.setText(lista.get(position).getApellido());
                correo.setText(lista.get(position).getCorreo());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void ObtenerListaPersonas() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        personaClass listPersonas = null;
        lista = new ArrayList<personaClass>();

        Cursor cursor = db.rawQuery(" SELECT * FROM " + transaccionesClass.tabla_personas, null);

        while (cursor.moveToNext()) {
            listPersonas = new personaClass();
            listPersonas.setId(cursor.getInt(0));
            listPersonas.setNombre(cursor.getString(1));
            listPersonas.setApellido(cursor.getString(2));
            listPersonas.setEdad(cursor.getInt(3));
            listPersonas.setCorreo(cursor.getString(4));
            listPersonas.setDireccion(cursor.getString(5));

            lista.add(listPersonas);

        }

        cursor.close();

        fillcombo();

    }

    private void fillcombo() {
        listaPersonas = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
            listaPersonas.add(lista.get(i).getId() + " | "
                    + lista.get(i).getNombre() + " | "
                    + lista.get(i).getApellido());
        }
    }
}