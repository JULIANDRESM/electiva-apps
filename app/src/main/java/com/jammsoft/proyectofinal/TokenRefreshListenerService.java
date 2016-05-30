package com.jammsoft.proyectofinal;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by JULIAN on 29/05/2016.
 */
public class TokenRefreshListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
       // Intent i = new Intent(this, RegistrarServicio.class);
       // startService(i);
    }
}