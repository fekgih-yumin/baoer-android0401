package com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wufan.baoer_android.R;
import com.example.wufan.baoer_android.main.HifiMusic.topTrendSearch.dummy.DummyContent.DummyItem;

import java.io.File;
import java.util.List;

import static android.R.attr.path;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTopTrendItemRecyclerViewAdapter extends RecyclerView.Adapter<MyTopTrendItemRecyclerViewAdapter.ViewHolder> {

    private List<String> contentTitles;
    private List<String> imgUrls;
    private final TopTrendListFragment.OnListFragmentInteractionListener mListener;

    public MyTopTrendItemRecyclerViewAdapter(List<String> items, TopTrendListFragment.OnListFragmentInteractionListener listener) {

        contentTitles = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_toptrenditem, parent, false);

        return new ViewHolder(view);




    }

    private int i=0;
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = contentTitles.get(position);
        holder.mIdView.setText(contentTitles.get(position));
//        File file = new File(imgUrls.get(position));
//        if(file.exists()){
//
//            Bitmap bm = BitmapFactory.decodeFile(imgUrls.get(position));
//
//            holder.mImageView.setImageBitmap(bm);
//
//        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contentTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public String mItem;
        private ImageView mImageView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.text_top);
            mImageView= (ImageView) view.findViewById(R.id.image_top);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
//    }
    }
    public void upDateContent(List<String> list){
        this.contentTitles =list;
    }
}
