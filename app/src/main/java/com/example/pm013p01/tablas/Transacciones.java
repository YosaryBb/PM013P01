package com.example.pm013p01.tablas;

public class Transacciones
{
    //nombre de la base de datos.

    public static final String  NamedDatabase= "PM01DB";
    //cracion de la base de datos.
    public static final String TbPersona="personas";
    //campos de la tablas persona.
    public static final String id="id";
    public static final String nombres="nombres";
    public static final String apellidos="apellidos";
    public static final String edad="edad";
    public static final String correo="correo";


//ddl
public static final String CTPersonas = "CREATE Table personas (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "nombres TEXT, apellidos TEXT, edad TEXT, correo TEXT)";

    public static final String DropTPersona = "Drop Table IF EXISTS personas";

    public static final String GetPersona = "SELECT * FROM" + Transacciones.TbPersona;
}
