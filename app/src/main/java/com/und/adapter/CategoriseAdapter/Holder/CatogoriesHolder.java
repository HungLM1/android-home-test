package com.und.adapter.CategoriseAdapter.Holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.und.R;
import com.und.adapter.Listenner.CategoriseEventListener;
import com.und.core.Layout.common.uBaseViewHolder;

/**
 * Created by hungle on 01/03/2019.
 */

public class CatogoriesHolder extends uBaseViewHolder<CategoriseEventListener> {

    public TextView itemTitle;

    public RecyclerView mRecyclerViews;

    public Button btnMore;

    public CatogoriesHolder(Context ctx, View view) {
        super(ctx, view);

        this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
        this.mRecyclerViews = (RecyclerView) view.findViewById(R.id.recycler_view_list);
        this.btnMore= (Button) view.findViewById(R.id.btnMore);
    }
}
