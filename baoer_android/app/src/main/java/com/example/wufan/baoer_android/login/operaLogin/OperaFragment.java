package com.example.wufan.baoer_android.login.operaLogin;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.main.MainActivity;
import com.example.wufan.baoer_android.util.RestClient;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

/**
 * A simple {@link Fragment} subclass.
 */
public class OperaFragment extends Fragment implements OperaContract.View {

    public static OperaFragment newInstance() {

        Bundle args = new Bundle();

        OperaFragment fragment = new OperaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private EditText edit_phone;
    private EditText edit_pwd;
    private Button btn_login;

    public OperaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_opera, container, false);
        edit_phone= (EditText) view.findViewById(R.id.edit_phone);
        edit_pwd= (EditText) view.findViewById(R.id.edit_pwd);
        btn_login= (Button) view.findViewById(R.id.btn_phoneLogin);
        Log.i("progress","come in opera");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.err.println("hello world");
                JSONObject jsonObject = new JSONObject();
                try {
                    //判断手机号
                    if (!checkPhone(edit_phone.getText().toString())) {
                        alert("请输入正确的手机号");
                    }
                    else if (edit_pwd.getText().toString().length()==0) {
                        alert("请填写密码");
                    }
                    else {
                        jsonObject.put("phoneNum",edit_phone.getText().toString());
                        jsonObject.put("passWord",edit_pwd.getText().toString());
                        System.err.println("_________________________");
                        postHttp("http://192.168.199.206:8080/api/login",jsonObject);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
    public void setPresenter(OperaContract.Presenter presenter) {

    }

    public Boolean checkPhone(String phoneNum){
//        Pattern pattern=Pattern.compile("^1\\d{10}$");
        Pattern pattern=Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
        Matcher matcher=pattern.matcher(phoneNum);
        Boolean b=matcher.find();
        Log.i("checkNum",b.toString());
        return b;
    }

    public Boolean postHttp(String url, JSONObject jsonObject) throws JSONException {
        Boolean isAuth=false;
        ByteArrayEntity entity=null;
        try {
            entity = new ByteArrayEntity(jsonObject.toString().getBytes("UTF-8"));
            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();

        System.err.println(url);
        asyncHttpClient.post(getContext(), url, entity, "application/json", new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                System.err.println(responseString);
                Intent intent = new Intent();
                intent.setClass(getContext(), MainActivity.class);
                getContext().startActivity(intent);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.err.println(statusCode);
                System.err.println("error");
            }
        });
        return isAuth;
    }

    public void alert(String text){
        new AlertDialog.Builder(getActivity()).setTitle("提示").setMessage(text).show();
    }
}
