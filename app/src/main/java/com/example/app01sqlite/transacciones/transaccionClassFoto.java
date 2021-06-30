package com.example.app01sqlite.transacciones;

public class transaccionClassFoto {

    //TABLA

    public static final String tabla_foto = "tbl_foto";

    public static final String id = "id";
    public static final String foto = "foto";

    //CREAR TABLA

    public static final String CreateTableFoto = "CREATE TABLE tbl_foto( id INTEGER PRIMARY KEY AUTOINCREMENT, foto BLOB)";
    public static final String DropTableFoto = "DROP TABLE IF EXISTS tbl_foto";


    /* Creacion del nombre de la base de datos */
    public static final String NameDataBase = "DBFoto";


}
