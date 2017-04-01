package com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wufan.baoer_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopTrendSearchFragment extends Fragment implements TopTrendSearchContract.View {

    public static TopTrendSearchFragment newInstance() {

        Bundle args = new Bundle();

        TopTrendSearchFragment fragment = new TopTrendSearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public TopTrendSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_trend_search, container, false);
    }

    @Override
    public void showTitleList(String title_list) {

    }

    @Override
    public void setPresenter(TopTrendSearchContract.Presenter presenter) {

    }
}
