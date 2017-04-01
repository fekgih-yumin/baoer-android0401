package com.example.wufan.baoer_android.main.HifiMusic.recommendation;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wufan.baoer_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendationFragment extends Fragment implements RecommendationContract.View {

    public static RecommendationFragment newInstance() {

        Bundle args = new Bundle();

        RecommendationFragment fragment = new RecommendationFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public RecommendationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommendation, container, false);
    }

    @Override
    public void showSongList() {

    }

    @Override
    public void setPresenter(RecommendationContract.Presenter presenter) {

    }
}
