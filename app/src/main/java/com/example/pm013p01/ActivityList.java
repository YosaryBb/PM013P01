package com.example.pm013p01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm013p01.configuracion.SQLiteConexion;
import com.example.pm013p01.tablas.Personas;
import com.example.pm013p01.tablas.Transacciones;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listperson;
    ArrayList<Personas> lista;
    ArrayList<String> listaconcatenada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        conexion = new SQLiteConexion(this, Transacciones.NamedDatabase, null, 1);

        listperson = (ListView) findViewById(R.id.listperson);

        GetListPerson();
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaconcatenada);
        listperson.setAdapter(adp);


        listperson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
Toast.makeText(getApplicationContext(), listaconcatenada.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void GetListPerson() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas listpersonas = null;
        lista = new ArrayList<Personas>();//lista objeto tipo persona.

       // Cursor cursor = db.rawQuery(Transacciones.GetPersonas, null);//
        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.TbPersona, null);


        while (cursor.moveToNext()) {
            listpersonas = new Personas();
            listpersonas.setId(cursor.getInt(0));
            listpersonas.setNombres(cursor.getString(1));
            listpersonas.setApellidos(cursor.getString(2));
            listpersonas.setEdad(cursor.getInt(3));
            listpersonas.setCorreo(cursor.getString(4));

            lista.add(listpersonas);
        }
        cursor.close();//para serrar la base de datos
        llenarlista();

    }

    private void llenarlista() {

        listaconcatenada = new ArrayList<String>();

        for (int i = 0; i < lista.size(); i++) {

            listaconcatenada.add(lista.get(i).getNombres() + " | " +
                    lista.get(i).getApellidos() + " | " +
                    lista.get(i).getEdad() + " | " +
                    lista.get(i).getCorreo());
        }

    }
}


