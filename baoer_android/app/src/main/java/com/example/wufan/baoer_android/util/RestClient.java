package com.example.wufan.baoer_android.util;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.protocol.RequestContent;

/**
 * Created by wufan on 17/3/24.
 */

public class RestClient {

    private static final String BASE_URL = "https://api.twitter.com/1/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
//    asyncHttpClient.post(getContext(),url,entity,"application/json",new JsonHttpResponseHandler(){
//        @Override
//        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//            super.onSuccess(statusCode, headers, response);
//            Log.e("rs",response.toString());
//        }
//
//        @Override
//        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//            System.err.println("false");
//            super.onFailure(statusCode, headers, throwable, errorResponse);
//        }
//    });

}
