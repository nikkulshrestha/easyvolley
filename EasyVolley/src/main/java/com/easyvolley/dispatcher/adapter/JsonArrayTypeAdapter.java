package com.easyvolley.dispatcher.adapter;

import android.util.Log;

import com.easyvolley.Callback;
import com.easyvolley.EasyVolleyError;
import com.easyvolley.EasyVolleyResponse;
import com.easyvolley.dispatcher.TypeAdapter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * JsonArray type response mapping handling.
 *
 * @author rohitsharma
 * @see TypeAdapter
 */
public class JsonArrayTypeAdapter implements TypeAdapter {

    @Override
    public void processResponse(Callback callback, String responseBody, EasyVolleyResponse response) {
        if (callback != null) {
            try {
                callback.onSuccess(new JSONArray(responseBody), response);
            } catch (JSONException e) {
                Log.e("JsonArrayTypeAdapter", e.getMessage(), e);
                callback.onError(EasyVolleyError.from(e.getMessage()));
            }
        }
    }

}
