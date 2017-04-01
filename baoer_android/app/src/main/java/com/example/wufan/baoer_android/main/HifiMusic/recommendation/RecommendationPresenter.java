package com.example.wufan.baoer_android.main.HifiMusic.recommendation;

import android.support.annotation.NonNull;

import com.example.wufan.baoer_android.util.AsyncHttp;

import org.json.JSONObject;

/**
 * Created by wufan on 17/3/30.
 */

public class RecommendationPresenter implements RecommendationContract.Presenter{

    private RecommendationContract.View mRecommendationFragment;
    private AsyncHttp asyncHttp=new AsyncHttp();

    public RecommendationPresenter(@NonNull RecommendationContract.View recommendationFragment){
        mRecommendationFragment=recommendationFragment;
        mRecommendationFragment.setPresenter(this);
    }


    @Override
    public String loadSongList() {
        String url="";
        String title = asyncHttp.getTitle(url);

        return title;
    }

    @Override
    public void start() {

    }
}
