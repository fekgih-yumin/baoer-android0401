package com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch;

import android.location.SettingInjectorService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.util.ActivityUtils;

import org.json.JSONException;

public class TopTrendSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_trend_search);

        TopTrendListFragment topTrendListFragment= (TopTrendListFragment) getFragmentManager().findFragmentById(R.id.list);
        if (topTrendListFragment==null) {
            topTrendListFragment=TopTrendListFragment.newInstance(3);
            ActivityUtils.addFragmentToActivity(getFragmentManager(),topTrendListFragment,R.id.list);
        }

        System.err.println("finished");

        TopTrendSearchPresenter topTrendSearchPresenter = new TopTrendSearchPresenter(topTrendListFragment);

//        try {
//            topTrendSearchPresenter.getTitleList();
//            System.err.println("finished");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }
}
