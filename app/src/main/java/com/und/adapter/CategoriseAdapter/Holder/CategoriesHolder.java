package com.und.adapter.CategoriseAdapter.Holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.und.R;
import com.und.adapter.EventListener.CategoriseEventListener;
import com.und.core.Layout.common.uBaseViewHolder;

import butterknife.BindView;

/**
 * Created by hungle on 01/03/2019.
 */

public class CategoriesHolder extends uBaseViewHolder<CategoriseEventListener> {

    /* the title property*/
    @BindView(R.id.itemTitle)
    TextView mItemTitle;

    /* the view property*/
    @BindView(R.id.recycler_view_list)
    RecyclerView mRecyclerViews;

    /* the button property*/
    @BindView(R.id.btnMore)
    Button mButtonMore;

    public CategoriesHolder(Context ctx, View view) {
        super(ctx, view);
    }

    public void setItemTitle(String title) {
        this.mItemTitle.setText(title);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layout) {
        this.mRecyclerViews.setLayoutManager(layout);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerViews.setAdapter(adapter);
    }

    public RecyclerView getContentView() {
        return this.mRecyclerViews;
    }
}
