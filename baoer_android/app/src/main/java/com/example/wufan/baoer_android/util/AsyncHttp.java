package com.example.wufan.baoer_android.util;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.DataAsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by wufan on 17/3/28.
 */

public class AsyncHttp {


    public static String getTitle(String url){
        AsyncHttpClient client= new AsyncHttpClient();
        final String[] response = {""};
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headrs, String responseString, Throwable throwable) {
                Log.i("http","error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.i("http",responseString);
                response[0] =responseString;
                System.err.println("-------------httpResponse");
            }

        });
        return response[0];
    }

    public static String postSearchHttp(String url, String value,String key){
        System.err.println("come in postSearchHttp");
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        requestParams.put("aipKey","1490863902964");
        requestParams.put(key,value);
        System.err.println(requestParams.toString());
        System.err.println(url);
        asyncHttpClient.post(url, requestParams, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.err.println("error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                System.err.println("success");
            }
        });
        return "ok";
    }
}
