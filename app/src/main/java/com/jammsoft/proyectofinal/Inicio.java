package com.jammsoft.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Inicio extends AppCompatActivity {

    private ImageButton ayuda, directorio, estudiante, horario, mapa, noticias, objetos, pagina, sugerencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        pagina = (ImageButton) findViewById(R.id.imbPagina);
        horario = (ImageButton) findViewById(R.id.imbHorario);
        mapa = (ImageButton) findViewById(R.id.imbMapa);
        estudiante = (ImageButton) findViewById(R.id.imbEstudiante);
        directorio = (ImageButton) findViewById(R.id.imbDirectorio);
    }

    public void clicDirectorio(View view){
        Intent intent = new Intent(this, Directorio.class);
        startActivity(intent);
    }

    public void clicPagina(View view){
        Intent intent = new Intent(this, PaginaOficial.class);
        startActivity(intent);
    }

    public void clicHorario(View view){
            Intent intent = new Intent(this, Horario.class);
            startActivity(intent);
    }

    public void clicMapa(View view){
        Intent intent = new Intent(this, MapaCampus.class);
        startActivity(intent);
    }

    public void clicEstudiante(View view){
        Intent intent = new Intent(this, Estudiante.class);
        startActivity(intent);
    }
}
