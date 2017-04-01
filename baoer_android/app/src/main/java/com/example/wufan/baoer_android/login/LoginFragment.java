package com.example.wufan.baoer_android.login;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.login.operaLogin.OperaActivity;

import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View{

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Button btn_phonelogin;

    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        btn_phonelogin= (Button) view.findViewById(R.id.btn_phoneLogin);
        btn_phonelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),OperaActivity.class );
                getActivity().startActivity(intent);
            }
        });

        return view;

    }

    @Override
    public void showLogin() {

    }

    @Override
    public void showPhoneLogin() {

    }

    @Override
    public void showWechatLogin() {

    }

    @Override
    public void showMircroBlogLogin() {

    }

    @Override
    public void showQQLogin() {

    }

    @Override
    public void showInvitationCodeIllustrate() {

    }

    @Override
    public void showError(String errorType) {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }
}
