package com.example.wufan.baoer_android.main.HifiMusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch.TopTrendListFragment;
import com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch.TopTrendSearchPresenter;
import com.example.wufan.baoer_android.util.ActivityUtils;

public class HifiMusicActivity extends AppCompatActivity implements TopTrendListFragment.OnListFragmentInteractionListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hifi_music);

        System.err.println("________________________________hello");


        HifiMusicFragment hifiMusicFragment= (HifiMusicFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (hifiMusicFragment==null) {
            hifiMusicFragment=HifiMusicFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),hifiMusicFragment,R.id.contentFrame);
        }


    }


    @Override
    public void onListFragmentInteraction(String item) {

    }
}
