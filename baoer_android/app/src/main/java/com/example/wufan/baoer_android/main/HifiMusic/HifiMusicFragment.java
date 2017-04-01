package com.example.wufan.baoer_android.main.HifiMusic;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.main.HifiMusic.classification.ClassificationContract;
import com.example.wufan.baoer_android.main.HifiMusic.classification.ClassificationFragment;
import com.example.wufan.baoer_android.main.HifiMusic.classification.ClassificationPresenter;
import com.example.wufan.baoer_android.main.HifiMusic.recommendation.RecommendationContract;
import com.example.wufan.baoer_android.main.HifiMusic.recommendation.RecommendationFragment;
import com.example.wufan.baoer_android.main.HifiMusic.recommendation.RecommendationPresenter;
import com.example.wufan.baoer_android.main.HifiMusic.search.SearchActivity;
import com.example.wufan.baoer_android.main.HifiMusic.search.SearchContract;
import com.example.wufan.baoer_android.main.HifiMusic.search.SearchFragment;
import com.example.wufan.baoer_android.main.HifiMusic.search.SearchPresenter;
import com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch.TopTrendListFragment;
import com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch.TopTrendSearchContract;
import com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch.TopTrendSearchFragment;
import com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch.TopTrendSearchPresenter;
import com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch.dummy.DummyContent;

import org.json.JSONArray;
import org.json.JSONException;

import static android.R.attr.tag;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * A simple {@link Fragment} subclass.
 */
public class HifiMusicFragment extends Fragment implements HifiMusicContract.View {

    public static HifiMusicFragment newInstance() {

        Bundle args = new Bundle();

        HifiMusicFragment fragment = new HifiMusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Button[] buttons = new Button[3];//0-topTrend 1-recommendation 2-classification
    private Fragment[] fragments = new Fragment[3];
    private static int tag = 0;//标签，用于判断上一个frag
    private static int downX = 0;//mouse down location
    private static int upX = 0;//mouse up location
    private View contentFrame;//触屏滑动区域
//    private static int i=0;//定义初始化fagment标签是0；
    private Button btn_search;
    private EditText edit_search;


    public HifiMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hifi_music, container, false);
        buttons[0] = (Button) view.findViewById(R.id.btn_topTrend);
        buttons[1] = (Button) view.findViewById(R.id.btn_rec);
        buttons[2] = (Button) view.findViewById(R.id.btn_class);
        btn_search= (Button) view.findViewById(R.id.btn_search);
        edit_search= (EditText) view.findViewById(R.id.edit_key);
        contentFrame = view.findViewById(R.id.contentFrame);

        if (savedInstanceState == null) {
            fragments[0] = TopTrendListFragment.newInstance(3);
            new TopTrendSearchPresenter((TopTrendSearchContract.View) fragments[0]);
            fragments[1] = RecommendationFragment.newInstance();
            new RecommendationPresenter((RecommendationContract.View) fragments[1]);
            fragments[2] = ClassificationFragment.newInstance();
            new ClassificationPresenter((ClassificationContract.View) fragments[2]);
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            for (Fragment fragment : fragments) {
                fragmentTransaction.add(R.id.contentFrame, fragment);
                fragmentTransaction.hide(fragment);
            }
            fragmentTransaction.show(fragments[0]);

            fragmentTransaction.commit();

        }

        //鼠标点击切换
        for (int i = buttons.length - 1; i >= 0; i--) {
            final int finalI = i;
            final int finalI1 = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAndHideFrag(fragments[finalI],fragments[tag]);
                    tag= finalI;
                    System.err.println(finalI1);
                }
            });
        }

        //点击搜索按钮
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //搜索关键词方法
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                System.err.println(edit_search.getText().toString());
                bundle.putString("key",edit_search.getText().toString());
                intent.putExtra("key",edit_search.getText().toString());
                intent.setClass(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return view;

    }


    @Override
    public void showTabFragment() {

    }

    @Override
    public void setPresenter(HifiMusicContract.Presenter presenter) {

    }

    public void showAndHideFrag(Fragment showFragment, Fragment hideFragment) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        if (showFragment == hideFragment) {
            return;
        }
        fragmentTransaction.hide(hideFragment);
        fragmentTransaction.show(showFragment);
        fragmentTransaction.commit();
    }



//        contentFrame.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        downX = (int) event.getX();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        upX = (int) event.getX();
//                        if (Math.abs(upX - downX) > 250) {
//                            if (i >= 0 && i < 3 && tag >= 0 && tag < 3) {
//                                if (upX > downX) {
//                                    i = i-1;
//                                    showAndHideFrag(fragments[i],fragments[tag]);
//                                    tag=tag-1;
//                                } else {
//                                    i = i+1;
//                                    showAndHideFrag(fragments[i],fragments[tag]);
//                                    tag=tag+1;
//                                }
//                            }
//
//                        }
//
//
//                }
//                return false;
//            }
//        });

}
