package com.example.app01sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import com.example.app01sqlite.transacciones.transaccionesClass;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class ActivityListview extends AppCompatActivity {
    //variables globales de la actividad

    SQLiteConexion conexion;
    ListView lista_personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //Conexion a la BDD
        conexion = new SQLiteConexion(this, transaccionesClass.NameDataBase, null, 1);
        lista_personas = (ListView)findViewById(R.id.lista_personas);

    }
}