package com.afzaln.venuevue.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by afzal on 1/17/2014.
 */
public class VvAuthenticatorService extends Service {

    private VvAuthenticator mAuthenticator;

    @Override
    public void onCreate() {
        mAuthenticator = new VvAuthenticator(this);
    }
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
