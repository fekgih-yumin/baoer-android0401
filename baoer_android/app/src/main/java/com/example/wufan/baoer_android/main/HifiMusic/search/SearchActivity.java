package com.example.wufan.baoer_android.main.HifiMusic.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.util.ActivityUtils;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        System.err.println("come in searchActivity");
        SearchFragment searchFragment= (SearchFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (searchFragment==null) {
            searchFragment=SearchFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),searchFragment,R.id.contentFrame);
        }
        new SearchPresenter(searchFragment);
    }
}
