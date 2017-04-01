package com.example.wufan.baoer_android.main;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.main.Bao.BaoFragment;
import com.example.wufan.baoer_android.main.HifiMusic.HifiMusicFragment;
import com.example.wufan.baoer_android.main.More.MoreFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainContract.View{
    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Button[] buttons=new Button[3];
    private Fragment[] fragments=new Fragment[3];


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        buttons[0]= (Button) view.findViewById(R.id.btn_bao);
        buttons[1]= (Button) view.findViewById(R.id.btn_hifi);
        buttons[2]= (Button) view.findViewById(R.id.btn_more);

        if (savedInstanceState==null) {
            fragments[0]= BaoFragment.newInstance();
            fragments[1]= HifiMusicFragment.newInstance();
            fragments[2]= MoreFragment.newInstance();
        }

        initText();
        return view;
    }

    public void initText(){
        buttons[0].setText("煲");
        buttons[1].setText("Hifi音乐");
        buttons[2].setText("更多");
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
