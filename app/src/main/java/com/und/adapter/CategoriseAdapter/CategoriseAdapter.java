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
import android.widget.Toast;

import com.und.R;
import com.und.adapter.CategoriseAdapter.Holder.CatogoriesHolder;
import com.und.adapter.KeywordAdapter.KeywordAdapter;
import com.und.models.CatagoriesModel;

import java.util.ArrayList;

public class CategoriseAdapter extends RecyclerView.Adapter<CatogoriesHolder> {

    private Context mContext;

    private ArrayList<CatagoriesModel> mDataList;

    protected ArrayList<RecyclerView> mRecyclerViews;

    public CategoriseAdapter(Context context, ArrayList<CatagoriesModel> dataList) {
        this.mDataList = dataList;
        this.mContext = context;

        mRecyclerViews = new ArrayList<>();
    }

    @NonNull
    @Override
    public CatogoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);

        CatogoriesHolder mh = new CatogoriesHolder(mContext, v);

        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull CatogoriesHolder holder, int position) {

        final String sectionName = mDataList.get(position).getHeaderTitle();

        ArrayList singleSectionItems = mDataList.get(position).getAllItemsInSection();

        holder.itemTitle.setText(sectionName);

        KeywordAdapter hRecyclerViewAdapter = new KeywordAdapter(mContext, singleSectionItems);

        holder.mRecyclerViews.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.mRecyclerViews.setAdapter(hRecyclerViewAdapter);

        mRecyclerViews.add(holder.mRecyclerViews);


        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void smoothScrollToPosition(int pos) {

        final Handler handler = new Handler();

        //100ms wait to scroll to item after applying changes
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mRecyclerViews.get(0).smoothScrollToPosition(pos);

            }}, 1000);
    }

    @Override
    public int getItemCount() {
        return (null != mDataList ? mDataList.size() : 0);
    }

    public int getAdapterItemCount (int viewIndex ) {

        return mRecyclerViews.get(viewIndex).getAdapter().getItemCount();
    }

}
