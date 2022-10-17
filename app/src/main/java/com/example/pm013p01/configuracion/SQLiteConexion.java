package com.example.pm013p01.configuracion;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pm013p01.tablas.Transacciones;

public class SQLiteConexion extends SQLiteOpenHelper
{
    //CONTRUCTIR DE LA CLASE EN BASE
    public SQLiteConexion(Context context,
                          String dbname,
                          SQLiteDatabase.CursorFactory
                                  factory,
                          int version)
    {
         super(context,dbname,factory,version);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
//CREACION DE TABLAS
        db.execSQL(Transacciones.CTPersonas);//CREANDO LA TABLA DE PERSONAS

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
  //ELIMINAMOS LOS DATOS
        db.execSQL(Transacciones.DropTPersona);
        onCreate(db);

    }
}
