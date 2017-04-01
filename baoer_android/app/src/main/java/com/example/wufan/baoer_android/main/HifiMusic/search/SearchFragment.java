package com.example.wufan.baoer_android.main.HifiMusic.search;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.util.AsyncHttp;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements SearchContract.View {
    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private SearchPresenter searchPresenter;
    private ListView search_list;
    private SearchAdapter searchAdapter;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        search_list = (ListView) view.findViewById(R.id.list_search);
        searchAdapter = new SearchAdapter(null);
        String key = getActivity().getIntent().getStringExtra("key");
        System.err.println(key);
        System.err.println(searchPresenter);
        try {
            searchPresenter.SearchKey(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        search_list.setAdapter(searchAdapter);

        return view;
    }

    @Override
    public void showTabFragment(String list) throws JSONException {
        searchAdapter.updateListView(new JSONArray(list));
    }


    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        System.err.println("come in setPresenter");
        searchPresenter = (SearchPresenter) presenter;
    }


    private static class SearchAdapter extends BaseAdapter {

        private JSONArray jsonArray;

        public SearchAdapter(JSONArray jsonArray) {
            this.jsonArray = jsonArray;
        }

        public void updateListView(JSONArray jsonArray) {
            this.jsonArray = jsonArray;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            if (jsonArray == null) {
                return 0;
            } else {
                return jsonArray.length();
            }
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;
            viewHolder viewHolder = new viewHolder();

            if (rowView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                rowView = layoutInflater.inflate(R.layout.search_item, parent, false);
                viewHolder.tv_title = (TextView) rowView.findViewById(R.id.search_text);
                rowView.setTag(viewHolder);
            } else {
                viewHolder = (SearchAdapter.viewHolder) rowView.getTag();
            }
            try {
                System.err.println(jsonArray.getJSONObject(position).get("chineseChar"));
                System.err.println(viewHolder.tv_title);
                viewHolder.tv_title.setText(jsonArray.getJSONObject(position).get("chineseChar").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return rowView;
        }

        class viewHolder {
            TextView tv_title;
        }
    }
}
