package com.example.wufan.baoer_android.login;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.util.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment= (LoginFragment) getFragmentManager().findFragmentById(R.id.contentFrame);

        if (loginFragment==null) {
            loginFragment=LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),loginFragment,R.id.contentFrame);
        }
    }
}
