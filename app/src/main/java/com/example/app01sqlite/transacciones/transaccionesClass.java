package com.example.app01sqlite.transacciones;

public class transaccionesClass {

    /* tablas */
    public static final String tabla_personas = "tbl_personas";


    /* Campos */
    public static final String id = "id";
    public static final String nombres = "nombre";
    public static final String apellidos = "apellido";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";


    /* tablas - CREATE , DROP */
    public static final String CreateTablePersonas = "CREATE TABLE tbl_personas( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, edad INTEGER," +
                                                     "correo TEXT, direccion TEXT)";
    public static final String DropTablePersonas = "DROP TABLE IF EXISTS tbl_personas";


    /* Creacion del nombre de la base de datos */
    public static final String NameDataBase = "DBCurso";

}
