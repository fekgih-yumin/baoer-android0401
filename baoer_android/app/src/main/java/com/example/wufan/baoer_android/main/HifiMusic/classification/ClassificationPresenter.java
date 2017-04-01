package com.example.wufan.baoer_android.main.HifiMusic.classification;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;

import cz.msebera.android.httpclient.Header;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by wufan on 17/4/1.
 */

public class ClassificationPresenter implements ClassificationContract.Presenter {

    private ClassificationContract.View mClassificationFragment;

    public ClassificationPresenter(ClassificationContract.View classificationFragment){
        mClassificationFragment=classificationFragment;
        mClassificationFragment.setPresenter(this);
    }

    @Override
    public void loadClassification() {
        String url="http://server.5ftech.com:48080/api/hifi/loadClassifications";
        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        asyncHttpClient.post(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.i("loadClassificationHttp","error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    Log.i("loadClassificationHttp","Success");
                    mClassificationFragment.showClassification(responseString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void loadAlbumList(String id) {
        String url="http://server.5ftech.com:48080/api/hifi/loadSubjectListByClassificationId";
        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        RequestParams requestParams=new RequestParams();
        requestParams.put("id",id);
        asyncHttpClient.post(url, requestParams, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.i("loadAlbumListHttp","error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.i("loadAlbumList","success");
                mClassificationFragment.showAlbumList(responseString);
            }
        });
    }

    @Override
    public void start() {

    }
}
