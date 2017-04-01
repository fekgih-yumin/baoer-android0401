package com.example.wufan.baoer_android.main.More;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.main.MainContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements MainContract.View{

    public static MoreFragment newInstance() {

        Bundle args = new Bundle();

        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void showInterface() {

    }

    @Override
    public void showMusic(String currentMusic) {

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
