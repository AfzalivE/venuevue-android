package com.afzaln.venuevue;

import android.app.Application;

import com.afzaln.venuevue.api.VvApi;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by afzal on 1/16/2014.
 */
public class VvApp extends Application {
    private static VvApp sInstance;

    public static VvApp get() {
        return sInstance;
    }

    private VvApi mApi;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        RequestQueue queue = Volley.newRequestQueue(this);
        mApi = new VvApi(queue);
    }

    public VvApi getApi() {
        return mApi;
    }
}
