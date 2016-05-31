package com.jammsoft.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Principal extends AppCompatActivity implements View.OnClickListener{

    Button btnIngresar;
    EditText txtUsuario, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtUsuario=(EditText) findViewById(R.id.txtUsuario);
        txtPassword=(EditText) findViewById(R.id.txtPassword);
        btnIngresar=(Button) findViewById(R.id.btnIngreso);

        btnIngresar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Thread tr=new Thread(){
            @Override
            public void run() {
                super.run();
                final String resultado = enviarDatosGET(txtUsuario.getText().toString(), txtPassword.getText().toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtenerDatosJSON(resultado);
                        if(r>0){
                            Intent i = new Intent(getApplicationContext(), Lenguaje.class);
                            i.putExtra("cod", txtUsuario.getText().toString());
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(), "Usuario o Clave incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        };
        tr.start();
    }

    public String enviarDatosGET (String usu, String pas){
        URL url = null;
        String linea = "";
        int respuesta=0;
        StringBuilder resul=null;

        try {
            url = new URL("http://192.168.1.10:81/ServiciosWeb/validar.php?usu="+usu+"&pas="+pas);
            HttpURLConnection conection=(HttpURLConnection) url.openConnection();
            respuesta=conection.getResponseCode();
            resul = new StringBuilder();

            if(respuesta==HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(conection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea=reader.readLine())!=null){
                    resul.append(linea);
                }
            }
        }catch (Exception e){}

        return resul.toString();
    }


    // Verifica si el json tiene o no tiene datos
    public int obtenerDatosJSON(String response){
        int res=0;

        try{
            JSONArray json=new JSONArray(response);
            if(json.length()>0){
                res=1;
            }
        }catch (Exception e){

        }
        return res;
    }


}
