package com.und.adapter.KeywordAdapter.Holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.und.R;
import com.und.adapter.EventListener.KeywordEventListener;
import com.und.core.Layout.common.uBaseViewHolder;

import butterknife.BindView;

/**
 * Created by hungle on 01/03/2019.
 */

public class KeywordHolder extends uBaseViewHolder<KeywordEventListener> {

    @BindView(R.id.tvTitle)
    TextView mTitle;

    @BindView(R.id.itemImage)
    ImageView mItemImage;

    public KeywordHolder(Context ctx, View view) {
        super(ctx, view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), mTitle.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setTitle (String title) {
        mTitle.setText(title);
    }
}
