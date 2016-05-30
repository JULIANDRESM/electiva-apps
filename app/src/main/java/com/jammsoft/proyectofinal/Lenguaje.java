package com.jammsoft.proyectofinal;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import utilidades.Utilidades;

public class Lenguaje extends AppCompatActivity {

    final Context context = this;  // documentar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenguaje);
        isPlayServicesInstalled();
        registrarServicio();
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


    public void registrarServicio() {

        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                String token = "";
                try {
                    InstanceID gcmTokenistanceID = InstanceID.getInstance(context);

                    token = gcmTokenistanceID.getToken(getString(R.string.gcm_defaultSenderId),
                            GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

                    GcmPubSub subscription = GcmPubSub.getInstance(context);
                    subscription.subscribe(token, "/topics/my_little_topic", null);
                } catch (IOException e) {
                    Log.i("TAG", "GCM Registration Token: " + e.getMessage().toString());
                }
                return null;
            }

        }.execute();
    }


    private boolean isPlayServicesInstalled() {
        GoogleApiAvailability getGoogleapiAvailability = GoogleApiAvailability.getInstance();
        int Code = getGoogleapiAvailability.isGooglePlayServicesAvailable(this);
        if (Code != ConnectionResult.SUCCESS) {
            if (getGoogleapiAvailability.isUserResolvableError(Code)) {
                getGoogleapiAvailability.getErrorDialog(this, Code, 9000)
                        .show();
            } else {
                Log.i("MainActivity", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

}
