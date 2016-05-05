package com.jammsoft.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class MapaCampus extends AppCompatActivity {

    private SubsamplingScaleImageView mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_campus);

        mapa = (SubsamplingScaleImageView) findViewById(R.id.mapa);
        mapa.setImage(ImageSource.asset("mapa_uniquindio2.png"));
    }
}
