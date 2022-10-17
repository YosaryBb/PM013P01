package com.example.pm013p01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPrinc extends AppCompatActivity {
Button btnadd,btnlist;//declaramos variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_princ);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnlist = (Button) findViewById(R.id.btnlist);

        btnadd.setOnClickListener(new View.OnClickListener() {// aqui creamos el evento del boton
            @Override
            public void onClick(View view) {
Intent intent = new Intent(getApplicationContext(),Activiryingresar.class);
startActivity(intent);
            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {// aqui creamos el evento del boton
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityList.class);
                startActivity(intent);
            }
        });





    }
}