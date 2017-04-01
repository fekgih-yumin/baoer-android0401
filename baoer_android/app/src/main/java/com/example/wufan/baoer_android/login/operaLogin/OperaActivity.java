package com.example.wufan.baoer_android.login.operaLogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.util.ActivityUtils;

public class OperaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opera);

        OperaFragment operaFragment= (OperaFragment) getFragmentManager().findFragmentById(R.id.contentFrame);

        if (operaFragment==null) {
            operaFragment=OperaFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),operaFragment,R.id.contentFrame);
        }
    }
}
