package com.example.wufan.baoer_android.main.HifiMusic.search;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.wufan.baoer_android.util.AsyncHttp;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static android.R.attr.value;

/**
 * Created by wufan on 17/3/30.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View mSeatchFragment;

    public SearchPresenter(@NonNull SearchContract.View searchFragment){
        mSeatchFragment=searchFragment;
        mSeatchFragment.setPresenter(this);
    }


    @Override
    public void SearchKey(String key) throws JSONException {
        String url="http://server.5ftech.com:48080/api/hifi/loadSearchKey";
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        requestParams.put("aipKey","1490863902964");
        requestParams.put("key",key);
        System.err.println(requestParams.toString());
        System.err.println(url);
        asyncHttpClient.post(url, requestParams, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.i("searchKeyHttp","error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                System.err.println("___________"+responseString);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(responseString);
                    JSONArray list = jsonObject.getJSONArray("list");
                    System.err.println(list);
                    mSeatchFragment.showTabFragment(list.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void start() {

    }
}
