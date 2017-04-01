package com.example.wufan.baoer_android.main.Bao;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wufan.baoer_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaoFragment extends Fragment implements BaoContract.View{
    public static BaoFragment newInstance() {

        Bundle args = new Bundle();

        BaoFragment fragment = new BaoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public BaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bao, container, false);
    }

    @Override
    public void showInterface() {

    }

    @Override
    public void setPresenter(BaoContract.Presenter presenter) {

    }
}
