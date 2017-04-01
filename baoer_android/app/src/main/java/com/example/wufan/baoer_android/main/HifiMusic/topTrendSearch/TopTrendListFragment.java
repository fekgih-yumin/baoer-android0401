package com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wufan.baoer_android.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TopTrendListFragment extends Fragment implements TopTrendSearchContract.View {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private TopTrendSearchContract.Presenter topTrendListPresenter;
    private RecyclerView recyclerView;
    private List<String> contentIds = new ArrayList<String>();
    private List<String> contentTitles = new ArrayList<String>();
    private List<String> imgUrls= new ArrayList<String>();
    private MyTopTrendItemRecyclerViewAdapter myTopTrendItemRecyclerViewAdapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TopTrendListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TopTrendListFragment newInstance(int columnCount) {
        TopTrendListFragment fragment = new TopTrendListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.err.println("+++++++++++++++++++++++++++++++++++++");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.err.println("====================================");
        View view = (View) inflater.inflate(R.layout.fragment_toptrenditem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
        }

        //调用presenter
        try {
            topTrendListPresenter.getTitleList();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //新建适配器
        myTopTrendItemRecyclerViewAdapter = new MyTopTrendItemRecyclerViewAdapter(contentTitles, mListener);
        recyclerView.setAdapter(myTopTrendItemRecyclerViewAdapter);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showTitleList(String title_list) throws JSONException {

        System.err.println("----------------------------");
        Log.i("progress", "showTitleList");
        System.err.println(title_list);
        JSONArray jsonArray = new JSONArray(title_list);
        int t = 5;
        for (int i = 0; i < t; i++) {
            String contentId = jsonArray.getJSONObject(i).get("contentId").toString();
            String contentTitle = jsonArray.getJSONObject(i).get("contentTitle").toString();
            String imgUrl = jsonArray.getJSONObject(i).get("imgUrl").toString();
            contentIds.add(contentId);
            contentTitles.add(contentTitle);
            imgUrls.add(imgUrl);

            System.err.println(".........."+imgUrl);
            System.err.println("============="+contentTitle);
        }
        myTopTrendItemRecyclerViewAdapter.upDateContent(contentTitles);
        System.err.println(contentTitles);

    }



    @Override
    public void setPresenter(@NonNull TopTrendSearchContract.Presenter presenter) {
        topTrendListPresenter = checkNotNull(presenter);
        System.err.println("---------------");
        Log.i("progress", "setPresenter");

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(String item);
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }

}
