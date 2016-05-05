package com.jammsoft.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class PaginaOficial extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_oficial);

        String url = "https://www.uniquindio.edu.co/";

        webView = (WebView) findViewById(R.id.paginaUniquindio);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}
