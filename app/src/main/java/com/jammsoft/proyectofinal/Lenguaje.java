package com.jammsoft.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import utilidades.Utilidades;

public class Lenguaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenguaje);
    }

    public void clicIdiomaEn(View view) {

        Utilidades.cambiarIdiomaEn(this);
        Intent intent = getIntent();
        finish();
        startActivity(intent);


        Intent intent2 = new Intent(this, Inicio.class);
        startActivity(intent2);
    }


    public void clicIdiomaEs(View view) {

        Utilidades.cambiarIdiomaEs(this);
        Intent intent = getIntent();
        finish();
        startActivity(intent);


        Intent intent2 = new Intent(this, Inicio.class);
        startActivity(intent2);
    }

}
