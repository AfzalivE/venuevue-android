package com.afzaln.venuevue.api;

import java.util.HashMap;
import java.util.Map;

import com.afzaln.venuevue.BuildConfig;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;

/**
 * Created by afzal on 1/16/2014.
 */
public class VvApi {

    public static final String hostname = "http://vv.api";

    private final RequestQueue mQueue;

    public VvApi(RequestQueue queue) {
        mQueue = queue;
    }

    public Request<?> login(String username, String password, Listener<String> listener, ErrorListener errorListener) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", BuildConfig.CLIENT_ID);
        params.put("client_secret", BuildConfig.CLIENT_SECRET);
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        return mQueue.add(new LoginRequest(params, listener, errorListener));
    }
}
