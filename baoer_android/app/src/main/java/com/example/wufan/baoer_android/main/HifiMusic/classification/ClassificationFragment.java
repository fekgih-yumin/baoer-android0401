package com.example.wufan.baoer_android.main.HifiMusic.classification;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wufan.baoer_android.R;

import org.json.JSONArray;
import org.json.JSONException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassificationFragment extends Fragment implements ClassificationContract.View {

    public static ClassificationFragment newInstance() {

        Bundle args = new Bundle();

        ClassificationFragment fragment = new ClassificationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ClassificationAdapter classificationAdapter;
    private ClassificationPresenter classificationPresenter;
    private ListView listView;

    public ClassificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_classification, container, false);
        listView= (ListView) view.findViewById(R.id.class_leftlist);
        classificationAdapter=new ClassificationAdapter(null);
        listView.setAdapter(classificationAdapter);
        classificationPresenter.loadClassification();



        return view;
    }

    @Override
    public void showClassification(String list) throws JSONException {
        JSONArray jsonArray = new JSONArray(list);
        System.err.println(jsonArray.toString());
        classificationAdapter.updateListView(jsonArray);

    }

    @Override
    public void showAlbumList(String albumList) {

    }

    @Override
    public void setPresenter(ClassificationContract.Presenter presenter) {
        classificationPresenter= (ClassificationPresenter) presenter;
    }


    private static class ClassificationAdapter extends BaseAdapter {

        private JSONArray jsonArray;

        public ClassificationAdapter(JSONArray jsonArray) {
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
                rowView = layoutInflater.inflate(R.layout.classification_item, parent, false);
                viewHolder.tv_title = (TextView) rowView.findViewById(R.id.class_text);
                rowView.setTag(viewHolder);
            } else {
                viewHolder = (ClassificationAdapter.viewHolder) rowView.getTag();
            }
            try {
                System.err.println(jsonArray.getJSONObject(position).get("menuname"));
                System.err.println(viewHolder.tv_title);
                viewHolder.tv_title.setText(jsonArray.getJSONObject(position).get("menuname").toString());
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
