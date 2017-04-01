package com.example.wufan.baoer_android.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment= (MainFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment==null) {
            mainFragment=MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),mainFragment,R.id.contentFrame);
        }
    }
}
