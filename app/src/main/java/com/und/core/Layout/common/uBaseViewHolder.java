package com.und.core.Layout.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.und.core.Listener.IEventListener;
import butterknife.ButterKnife;

/**
 * Created by Forev on 9/30/2016.
 */

public class uBaseViewHolder<L extends IEventListener> extends RecyclerView.ViewHolder {

    L mListener;
    protected Context mContext;

    public uBaseViewHolder(Context ctx, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mContext = ctx;
    }

    public <T> void bind(L callback, final T data, final int position) {
        this.mListener = callback;
        itemView.setClickable(true);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener !=null)
                {
                    mListener.OnAdapterItemClick(data, position);
                }
            }
        });
    }
}