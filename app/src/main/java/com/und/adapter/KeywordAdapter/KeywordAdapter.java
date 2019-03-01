package com.und.adapter.KeywordAdapter;

/**
 * Created by hungle on 01/03/2019.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.und.adapter.KeywordAdapter.Holder.KeywordHolder;
import com.und.models.KeyworkModel;
import com.und.R;

import java.util.ArrayList;

public class KeywordAdapter extends RecyclerView.Adapter<KeywordHolder> {

    private ArrayList<KeyworkModel> mItemsList;
    private Context mContext;

    public KeywordAdapter(Context context, ArrayList<KeyworkModel> itemsList) {
        this.mItemsList = itemsList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public KeywordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_single_card, null);
        KeywordHolder mh = new KeywordHolder(mContext, v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull KeywordHolder holder, int position) {

        KeyworkModel singleItem = mItemsList.get(position);

        holder.tvTitle.setText(singleItem.getName());

    }

    @Override
    public int getItemCount() {
        return (null != mItemsList ? mItemsList.size() : 0);
    }
}
