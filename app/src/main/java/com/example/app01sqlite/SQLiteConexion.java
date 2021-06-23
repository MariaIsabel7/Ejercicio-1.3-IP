package com.example.app01sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.app01sqlite.transacciones.transaccionesClass;

public class SQLiteConexion extends SQLiteOpenHelper {

    public SQLiteConexion(Context context, String bddname, SQLiteDatabase.CursorFactory factory, int version){
        super(context, bddname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(transaccionesClass.CreateTablePersonas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(transaccionesClass.DropTablePersonas);
        onCreate(db);
    }

}
