package com.example.pm013p01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm013p01.configuracion.SQLiteConexion;
import com.example.pm013p01.tablas.Transacciones;

public class Activiryingresar extends AppCompatActivity {

Button btnn;
EditText nombres, apellidos, edad, correo;

 private void config(){
     nombres= (EditText) findViewById(R.id.ai_nombre);
     apellidos= (EditText) findViewById(R.id.ai_apellido);
     edad = (EditText) findViewById(R.id.ai_edad);
     correo = (EditText) findViewById(R.id.ai_correo);
     btnn= (Button) findViewById(R.id.btnn);
 }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiryingresar);
      config();

      btnn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
 AgregarPersona();
          }
      });



    }

    private void AgregarPersona() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NamedDatabase,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres,nombres.getText().toString());
        valores.put(Transacciones.apellidos,apellidos.getText().toString());
        valores.put(Transacciones.edad,edad.getText().toString());
        valores.put(Transacciones.correo,correo.getText().toString());


        Long resultado = db.insert(Transacciones.TbPersona,Transacciones.id,valores);
        Toast.makeText(getApplicationContext(),"Registro Ingresado"+resultado.toString(),Toast.LENGTH_LONG).show();



        db.close();
        ClearScreen();// ejemplo de un metodo declarado



    }

    private void ClearScreen() {//metodo creado PAARA limpiar
     nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
    }
}