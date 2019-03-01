package com.und.adapter.CategoriseAdapter;

/**
 * Created by hungle on 01/03/2019.
 */

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.und.R;
import com.und.adapter.CategoriseAdapter.Holder.CategoriesHolder;
import com.und.adapter.KeywordAdapter.KeywordAdapter;
import com.und.models.CatagoriesModel;

import java.util.ArrayList;

public class CategoriseAdapter extends RecyclerView.Adapter<CategoriesHolder> {

    private Context mContext;

    private ArrayList<CatagoriesModel> mDataList;

    protected ArrayList<RecyclerView> mContentViews;

    public CategoriseAdapter(Context context, ArrayList<CatagoriesModel> dataList) {
        this.mDataList = dataList;
        this.mContext = context;

        mContentViews = new ArrayList<>();
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);

        CategoriesHolder mh = new CategoriesHolder(mContext, v);

        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {

        final String sectionName = mDataList.get(position).getHeaderTitle();

        ArrayList sectionItems = mDataList.get(position).getAllItemsInSection();

        holder.setItemTitle(sectionName);

        KeywordAdapter KeywordAdapter = new KeywordAdapter(mContext, sectionItems);

        holder.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        holder.setAdapter(KeywordAdapter);

        mContentViews.add(holder.getContentView());
    }

    public void smoothScrollToPosition(int pos) {

        final Handler handler = new Handler();

        //1000ms wait to scroll to item after applying changes
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mContentViews.get(0).smoothScrollToPosition(pos);

            }}, 1000);
    }

    @Override
    public int getItemCount() {
        return (null != mDataList ? mDataList.size() : 0);
    }

    public int getAdapterItemCount (int viewIndex ) {

        return mContentViews.get(viewIndex).getAdapter().getItemCount();
    }

}
