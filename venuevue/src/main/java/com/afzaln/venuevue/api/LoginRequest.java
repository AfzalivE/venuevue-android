package com.afzaln.venuevue.api;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;

/**
 * Created by afzal on 1/16/2014.
 */
public class LoginRequest extends Request<String> {

    private static final String TAG = LoginRequest.class.getSimpleName();
    private static final String sUrl = VvApi.hostname + "/oauth/access_token";

    private final Listener<String> mListener;
    private Map<String, String> mParams;

    public LoginRequest(Map<String, String> params, Listener<String> listener, ErrorListener errorListener) {
        super(Method.POST, sUrl, errorListener);
        mListener = listener;
        mParams = params;

    }

    @Override
    public Map<String, String> getParams() {
        return mParams;
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String jsonString = new String(response.data);
        Log.d(TAG, jsonString);
        // TODO parse auth token and return it
        return Response.success(jsonString, getCacheEntry());
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }

}
