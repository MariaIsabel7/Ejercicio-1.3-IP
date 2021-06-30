package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.app01sqlite.tables.personaClass;
import com.example.app01sqlite.transacciones.transaccionesClass;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;


public class ActivityListview extends AppCompatActivity {
    //variables globales de la actividad

    SQLiteConexion conexion;
    ListView lista_personas;
    ArrayList<personaClass> lista;
    ArrayList<String> ArregloPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //Conexion a la BDD
        conexion = new SQLiteConexion(this, transaccionesClass.NameDataBase, null, 1);
        lista_personas = (ListView)findViewById(R.id.lista_personas);

        ObtenerListaPersonas();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloPersonas);
        lista_personas.setAdapter(adp);

        lista_personas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion = "ID: " + lista.get(position).getId() + "\n";
                informacion += "Nombre: " + lista.get(position).getNombre();

                Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_LONG).show();

                Intent compartir = new Intent();
                compartir.setAction(Intent.ACTION_SEND);
                compartir.putExtra(Intent.EXTRA_TEXT, informacion);
                compartir.setType("text/plain");

                Intent share =Intent.createChooser(compartir, null);
                startActivity(share);
            }
        });


    }

    private void ObtenerListaPersonas() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        personaClass listPersonas = null;
        lista = new ArrayList<personaClass>();

        Cursor cursor = db.rawQuery(" SELECT * FROM " + transaccionesClass.tabla_personas, null);

        while (cursor.moveToNext()){
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

        fillList();
        
    }

    private void fillList() {
        ArregloPersonas = new ArrayList<String>();
        for(int i = 0; i < lista.size(); i++){
            ArregloPersonas.add(lista.get(i).getId() + " | "
                              + lista.get(i).getNombre() + " | "
                              + lista.get(i).getApellido());
        }
    }
}