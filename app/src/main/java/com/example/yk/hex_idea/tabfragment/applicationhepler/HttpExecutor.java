package com.example.yk.hex_idea.tabfragment.applicationhepler;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

/**
 * Created by Admin on 25-03-2017.
 */

public class HttpExecutor {
    String responsce = "";

    public String httpPost(JSONObject requestParam, String url, Context context) {
        Log.d("httpPost()","Enter in httpPost-->");
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(requestParam.toString());
            stringEntity.setContentType("application/json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        AsyncHttpClient client = new AsyncHttpClient();

        client.post(context, url, stringEntity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                responsce = new String(responseBody);
                Log.d("Responsce on Sucess ", "" + statusCode + " Respnsce ::: " + responsce);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Responsce on Failer ", "" + statusCode);
                responsce = new String(responseBody);
            }
        });
        Log.d("httpPost()","Exit in httpPost-->");
        return responsce;
    }


}
