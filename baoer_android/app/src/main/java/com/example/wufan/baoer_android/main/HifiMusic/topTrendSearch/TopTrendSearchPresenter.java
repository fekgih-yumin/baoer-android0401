package com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.wufan.baoer_android.login.LoginFragment;
import com.example.wufan.baoer_android.talk.TalkContract;
import com.example.wufan.baoer_android.util.AsyncHttp;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by wufan on 17/3/28.
 */

public class TopTrendSearchPresenter implements TopTrendSearchContract.Presenter {

    private TopTrendSearchContract.View mTopTrendListFragment;

    public TopTrendSearchPresenter(@NonNull TopTrendSearchContract.View topTrendListFragment){
        mTopTrendListFragment=topTrendListFragment;
        mTopTrendListFragment.setPresenter(this);

    }

    @Override
    public void getTitleList(){
        System.err.println("-----------------------------------------");
        Log.i("progress","come in getTitleList");
        String url="http://192.168.199.206:8080/api/hifi/menu";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.i("http","error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    System.err.println("----------------------------------http");
                    mTopTrendListFragment.showTitleList(responseString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public String getSubjectDetail() {
        return null;
    }

    @Override
    public void start() {

    }
}
